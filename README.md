# Code Lập trình mạng trên DBPTIT

- [Đề môn Lập trình mạng](DB_PTIT_EXERCISES.md)
- [24 đề UDP trong sách bài tập 2024 và 23 lời giải](UDP2024/README.md)
- Source: https://github.com/nvbangg/PTIT-Docs

## TCP

### Cấu trúc chung:
```java
import java.io.*;
import java.net.*;

public class TCP {
    public static void main(String[] args) throws Exception {
        // 1. Khởi tạo Socket kết nối tới Server
        Socket socket = new Socket("36.50.135.242", 2001); // IP Server và Port theo đề bài
        
        // 2. Khởi tạo các luồng đọc/ghi tương ứng theo dạng đề
        // 3. Gửi "Mã sinh viên;Mã câu hỏi"
        // 4. Nhận dữ liệu từ Server
        // ! Cụ thể mẫu code phần 2, 3, 4 theo các dạng đề bên dưới

        // 5. Xử lý logic theo yêu cầu đề bài

        // 6. Gửi kết quả về Server (tương tự bước 3)

        // 7. Đóng kết nối
        socket.close();
    }
}
```

### 1. TCP Character Stream
```java
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Gửi mã SV; Mã câu hỏi (bắt buộc có \n để báo hết dòng và flush để đẩy đi ngay
        bw.write("B23DCCN067;jNEYbPud\n"); 
        bw.flush();

        // Nhận chuỗi từ Server (tự động đọc đến khi gặp \n)
        String str = br.readLine();
```

### 2. TCP Byte Stream
```java
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        // Gửi mảng byte trực tiếp
        os.write("B23DCCN067;jNEYbPud".getBytes());

        // Nhận mảng byte từ Server
        byte[] buff = new byte[1024];
        int bytes = is.read(buff); // là số lượng byte thực tế nhận được
        String str = new String(buff, 0, bytes).trim(); // Không được dùng buff.length để tạo String vì buff có thể chưa được lấp đầy.
```
- không cần `.flush()` vì ghi xuống socket ngay ở `OutputStream os = socket.getOutputStream();` mà không qua trung gian để giữ dữ liệu chờ
- `read(buff)` ở đây là đọc dữ liệu từ mạng để đổ vào mảng buff.
- Nếu `write(buff)` thì sẽ là lấy dữ liệu từ buff để ghi ra đĩa/server

### 3. TCP Data Stream
```java
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        dos.writeUTF("B23DCCN067;jNEYbPud");
        dos.flush();

        // Nhận dữ liệu từ Server (tùy theo kiểu dữ liệu đề bài gửi về)
        int n = dis.readInt();
        String str = dis.readUTF();
```
- `writeUTF()` ghi chuỗi theo định dạng của DataOutputStream, phía nhận dùng `readUTF()` sẽ tự động đọc đúng độ dài chuỗi mà không cần ký tự xuống dòng \n. (Không thay thế được bằng \n mà buộc dùng UTF)
- ghi số nguyên sẽ là: `dos.writeInt(num)`

### 4. TCP Object Stream
```java
        // Khởi tạo OutputStream trước InputStream để tránh bị deadlock luồng Object
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        oos.writeObject("B23DCCN067;jNEYbPud");
        oos.flush();

        // Nhận đối tượng từ Server và ép kiểu về đúng Class của đề bài
        Student student = (Student) ois.readObject();
```
- Lớp đối tượng (ví dụ: `Student`, `Customer`...) bắt buộc phải có `implements Serializable` và nằm đúng package (ví dụ `package TCP;`) nếu đề bài chỉ định
- Bắt buộc tạo `ObjectOutputStream` trước `ObjectInputStream`: Khi `new ObjectInputStream`, Java sẽ chặn chương trình để đợi đọc header từ đối tác. Tạo `ObjectOutputStream` trước sẽ phát ngay header sang Server, tránh việc cả hai đầu cùng đứng chờ nhau gây treo ứng dụng (deadlock).

## UDP

UDP dùng `DatagramSocket` để gửi/nhận từng gói `DatagramPacket`. Mỗi lần gửi cần chỉ rõ IP và port của Server.

| Dạng đề | Port | Dữ liệu nhận / gửi kết quả |
| --- | --- | --- |
| UDP Data Type | 2207 | Chuỗi `requestId;dữ liệu` |
| UDP String | 2208 | Chuỗi `requestId;dữ liệu` |
| UDP Object | 2209 | 8 byte requestId + Object đã serialize |

### Cấu trúc chung:

```java
import java.io.*;
import java.net.*;

public class UDP {
    public static void main(String[] args) throws Exception {
        // 1. Khởi tạo Socket, IP, Port
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        int port = 2207; // Đổi port theo dạng đề trong bảng trên

        // 2. Gửi ";Mã sinh viên;Mã câu hỏi" (có dấu ; ở đầu)
        byte[] req = ";B23DCCN067;toft6ekh".getBytes();
        socket.send(new DatagramPacket(req, req.length, ip, port));

        // 3. Nhận gói tin từ Server (dùng chung cho cả 3 dạng đề)
        byte[] buff = new byte[2048]; // Buffer phải đủ lớn để chứa gói tin của đề
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        socket.receive(dp);

        // 4. Tách requestId và đọc dữ liệu theo dạng đề
        // 5. Xử lý logic theo yêu cầu đề bài
        // 6. Ghép requestId với kết quả và gửi về Server
        // ! Cụ thể mẫu code phần 4, 5, 6 theo các dạng đề bên dưới

        // 7. Đóng socket
        socket.close();
    }
}
```

- `req` / `out`: mảng byte cần gửi; `buff`: mảng byte dùng để nhận; `dp`: gói tin nhận được.
- `dp.getLength()` là số byte thực tế nhận được; `buff.length` là sức chứa của buffer. Luôn đọc đúng `dp.getLength()`.
- UDP gửi cả gói nên không cần ký tự xuống dòng `\n` hay `flush()` cho `socket.send()`.

### 1. UDP Data Type / String

Cả hai dạng đều gửi/nhận **chuỗi**. Data Type chỉ khác phần xử lý số, không dùng `DataInputStream` / `DataOutputStream` như TCP Data Stream.

```java
        // 4. Đọc chuỗi "requestId;data" từ gói tin
        String s = new String(buff, 0, dp.getLength());
        String[] parts = s.split(";");
        String requestId = parts[0];
        String data = parts[1].trim();

        // 5. Xử lý data theo đề, lưu kết quả vào biến result
        String result = "...";

        // 6. Gửi chuỗi "requestId;kết quả"
        String res = requestId + ";" + result;
        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));
```

- `split(";", 2)` tách thành tối đa 2 phần: requestId và toàn bộ dữ liệu phía sau.
- Riêng đề `UDP_DATA1` nhận `requestId;n;dãy số`: dùng `split(";")`, đọc `n` ở `parts[1]`, dãy số ở `parts[2]`; tách các số bằng `split(",")`.

### 2. UDP Object

Gói tin có dạng `[8 byte requestId][các byte Object]`. Giữ nguyên 8 byte đầu, chỉ đọc và sửa Object phía sau. Ví dụ với lớp `UDP.Student` (thêm `import UDP.Student;`):

```java
        // 4. Bỏ qua 8 byte requestId để đọc Object
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buff, 8, dp.getLength() - 8));
        Student student = (Student) ois.readObject();

        // 5. Sửa các thuộc tính của student theo đề bài

        // 6. Ghi 8 byte requestId trước, rồi ghi Object vào cùng buffer gửi
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buff, 0, 8);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        byte[] out = baos.toByteArray();
        socket.send(new DatagramPacket(out, out.length, ip, port));
```

- Lớp đối tượng phải đúng package `UDP`, thuộc tính và `serialVersionUID` theo đề, có `implements Serializable`.
- `ByteArrayInputStream(buff, 8, dp.getLength() - 8)`: đọc từ vị trí 8, lấy số byte còn lại của gói tin.
- `baos.write(buff, 0, 8)`: chép nguyên 8 byte requestId vào đầu buffer gửi. Phải gọi **trước** `new ObjectOutputStream(baos)` vì lệnh khởi tạo này ghi header Object ngay.
- `ObjectInputStream` / `ObjectOutputStream` ở đây đọc/ghi trên mảng byte trong bộ nhớ; `socket.receive()` / `socket.send()` mới là phần giao tiếp qua mạng.

Nhớ luồng chung: **Tạo socket → gửi mã → nhận gói → tách requestId, xử lý → ghép requestId, gửi kết quả → đóng socket**.
