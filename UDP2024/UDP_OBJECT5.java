package UDP2024;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import UDP.Book;

public class UDP_OBJECT5 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(args.length > 0 ? args[0] : "36.50.135.242");
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 809;

        byte[] req = ";B23DCCN067;THAY_MA_CAU_HOI".getBytes(StandardCharsets.UTF_8);
        socket.send(new DatagramPacket(req, req.length, ip, port));

        byte[] buff = new byte[65507];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buff, 8, dp.getLength() - 8));
        Book book = (Book) ois.readObject();

        String[] words = book.title.trim().toLowerCase(Locale.ROOT).split(" ");
        String title = "";
        for (String w : words) {
            if (w.isEmpty()) continue;
            title += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
        }
        book.title = title.trim();

        // Lay tu dau lam ho, cac tu con lai lam ten theo mau tham khao.
        String[] author = book.author.trim().replace(",", " ").split(" ");
        String name = "";
        for (int i = 1; i < author.length; i++) {
            if (!author[i].isEmpty()) name += author[i] + " ";
        }
        book.author = author[0];
        if (!name.isEmpty()) book.author += ", " + name.trim();

        // De chi cho mau ISBN 13 chu so, chia nhom 3-1-2-6-1.
        String isbn = book.isbn.replaceAll("[^0-9]", "");
        if (isbn.length() != 13) {
            throw new IllegalArgumentException("De bai chi cho mau ISBN 13 chu so.");
        }
        book.isbn = isbn.substring(0, 3) + "-" + isbn.substring(3, 4) + "-"
                + isbn.substring(4, 6) + "-" + isbn.substring(6, 12) + "-" + isbn.substring(12);

        String[] date = book.publishDate.split("-");
        book.publishDate = date[1] + "/" + date[0];

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buff, 0, 8);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();

        byte[] out = baos.toByteArray();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        socket.close();
    }
}

