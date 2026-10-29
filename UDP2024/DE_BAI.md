# Đề bài UDP trong Sách bài tập Lập trình mạng năm 2024

Nguồn: [Bài tập Lập trình mạng của Hungdn năm 2024](<../BT/Bai tap - Lap trinh mang - Hungdn - 2024.docx>), Phần 2 Lập trình Socket với giao thức UDP.

Gồm 24 câu: 10 câu UDP Data type, 9 câu UDP Character và 5 câu UDP Object. Số câu được giữ theo từng nhóm trong tài liệu gốc.

## UDP Data type

### Câu 1

Code: [UDP_DATA1.java](UDP_DATA1.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;371EA16D”

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId; n; A1,A2,...An”, với: requestId là chuỗi ngẫu nhiên duy nhất; n là một số ngẫu nhiên nhỏ hơn 100; dãy A1, A2 ... Am với m <= n là các giá trị nguyên liên tiếp, nhỏ hơn hoặc bằng n và không trùng nhau. Ví dụ: requestId;10;2,3,5,6,9

c. Tìm kiếm các giá trị còn thiếu và gửi lên server theo định dạng “requestId;B1,B2,...,Bm”. Ví dụ: requestId;1,4,7,8,10

d.Đóng socket và kết thúc chương trình.

### Câu 2

Code: [UDP_DATA2.java](UDP_DATA2.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với: requestId là chuỗi ngẫu nhiên duy nhất; string là một chuỗi chứa các chuỗi con bị thay đổi vị trí.Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"

c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý:

"M6dpWTEaWXlSzDwePHupvPcveM3xgA1gIPFfgEanYPR3gH8ahNUEEKHLIt"

d. Đóng socket và kết thúc chương trình.

### Câu 3

Code: [UDP_DATA3.java](UDP_DATA3.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN011;A1F3D5B7".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;num", với: requestId là chuỗi ngẫu nhiên duy nhất; num là một số nguyên lớn.

c. Tính tổng các chữ số trong num và gửi lại tổng này về server theo định dạng "requestId;sumDigits".

d. Đóng socket và kết thúc chương trình.

### Câu 4

Code: [UDP_DATA4.java](UDP_DATA4.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;73457A17”

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;n;A1,A2,...An” , với requestId là chuỗi ngẫu nhiên duy nhất; n là một số ngẫu nhiên nhỏ hơn 100; dãy  A1, A2 ... Am (m <= n) là các giá trị ngẫu nhiên nhỏ hơn hoặc bằng n và có thể trùng nhau. Ex: requestId;10;2,3,5,6,5

c. Tìm kiếm các giá trị còn thiếu và gửi lên server theo định dạng “requestId;B1,B2,...,Bm” . Ex: requestId;1,4,7,8,9,10

d. Đóng socket và kết thúc chương trình.

### Câu 5

Code: [UDP_DATA5.java](UDP_DATA5.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;DC73CA2E”

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;a1,a2,...,a50” với requestId là chuỗi ngẫu nhiên duy nhất; a1 -> a50 là 50 số nguyên ngẫu nhiên

c. Thực hiện tìm giá trị lớn nhất và giá trị nhỏ nhất thông điệp trong a1 -> a50 và gửi thông điệp lên lên server theo định dạng “requestId;max,min”

d. Đóng socket và kết thúc chương trình.

### Câu 6

Code: [UDP_DATA6.java](UDP_DATA6.java)

Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự “A” sẽ được thay thế bằng ký tự “D”. Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu xây dựng chương trình client trao đổi thông tin với server theo kịch bản mô tả dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;825EE3A7"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strEncode;s".

requestId là chuỗi ngẫu nhiên duy nhất

strEncode là chuỗi thông điệp bị mã hóa

s là số nguyên chứa giá trị độ dịch của mã

c. Giải mã tìm thông điệp ban đầu và gửi lên server theo định dạng “requestId;strDecode”

d. Đóng socket và kết thúc chương trình.

### Câu 7

Code: [UDP_DATA7.java](UDP_DATA7.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN004;99D9F604”

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;z1,z2,...,z50” với requestId là chuỗi ngẫu nhiên duy nhất; z1,z2,...,z50 là 50 số dãy nguyên ngẫu nhiên.

c. Thực hiện tìm số lớn thứ hai và số nhỏ thứ hai dãy các số nguyên z1,z2,...,z50 và gửi thông điệp lên server theo định dạng “requestId;secondMax,secondMin”

d. Đóng socket và kết thúc chương trình

### Câu 8

Code: [UDP_DATA8.java](UDP_DATA8.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n", với requestId là chuỗi ngẫu nhiên duy nhất; n là một số nguyên ngẫu nhiên ≤ 100.

c. Thực hiện tính toán và gửi về server danh sách n số nguyên tố đầu tiên theo định dạng "requestId;p1,p2,...,pn", trong đó p1,p2,...,pn là các số nguyên tố.

d. Đóng socket và kết thúc chương trình.

### Câu 9

Code: [UDP_DATA9.java](UDP_DATA9.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó: requestId là chuỗi ngẫu nhiên duy nhất; n là số phần tử của mảng; k là kích thước cửa sổ trượt (k < n); dãy z1,z2,...,zn là n phần tử là số nguyên của mảng.

c. Tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.

Ví dụ: "requestId;5;3;1,5,2,3,4" -> Kết quả: "requestId;5,5,4"

d. Đóng socket và kết thúc chương trình.

### Câu 10

Code: [UDP_DATA10.java](UDP_DATA10.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 807. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".Ví dụ: ";B15DCCN010;D3F9A7B8"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;a;b", với:

requestId là chuỗi ngẫu nhiên duy nhất.

a và b là chuỗi thể hiện hai số nguyên lớn (hơn hoặc bằng 10 chữ số).

Ví dụ: "X1Y2Z3;9876543210;123456789"

c. Tính tổng và hiệu của hai số a và b, gửi thông điệp lên server theo định dạng "requestId;sum;difference".Ví dụ:

Nếu nhận được "X1Y2Z3;9876543210;123456789", tổng là 9999999999 và hiệu là 9753086421. Kết quả gửi lại sẽ là "X1Y2Z3;9999999999;9753086421".

d. Đóng socket và kết thúc chương trình.

## UDP Character

### Câu 1

Code: [UDP_STRING1.java](UDP_STRING1.java)

Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client tương tác với server kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”

b. Nhận thông điệp từ server theo định dạng “requestId; data”, với requestId là một chuỗi ngẫu nhiên duy nhất; data là chuỗi dữ liệu đầu vào cần xử lý.

Ex: “requestId;Qnc8d5x78aldSGWWmaAAjyg3”

c. Tìm kiếm ký tự xuất hiện nhiều nhất trong chuỗi và gửi lên server theo định dạng “requestId;ký tự xuất hiện nhiều nhất: các vị trí xuất hiện ký tự đó”. ví dụ: “requestId;8:4,9,”

d. Đóng socket và kết thúc chương trình

### Câu 2

Code: [UDP_STRING2.java](UDP_STRING2.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:     requestId là chuỗi ngẫu nhiên duy nhất; b1 là số nhị phân thứ nhất; b2 là số nhị phân thứ hai. Ví dụ: requestId;0100011111001101,1101000111110101

c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”. Kết quả: requestId;72130

d. Đóng socket và kết thúc chương trình.

### Câu 3

Code: [UDP_STRING3.java](UDP_STRING3.java)

Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 808 . Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode”. Ví dụ: ";B15DCCN001;B34D51E0"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;str1;str2". Với requestId là chuỗi ngẫu nhiên duy nhất; str1,str2 lần lượt là chuỗi thứ nhất và chuỗi thứ hai

c. Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai, giữ nguyên thứ tự xuất hiện. Gửi thông điệp là một chuỗi lên server theo định dạng "requestId;strOutput", trong đó chuỗi strOutput là chuỗi đã được xử lý ở trên.

d. Đóng socket và kết thúc chương trình.

### Câu 4

Code: [UDP_STRING4.java](UDP_STRING4.java)

Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;5B35BCC1”

b. Nhận thông điệp từ server theo định dạng “requestId;data”, trong đó: requestId là một chuỗi ngẫu nhiên duy nhất; data là chuỗi dữ liệu cần xử lý;

c.Xử lý chuẩn hóa chuỗi đã nhận thành theo nguyên tắc: Ký tự đầu tiên của từng từ trong chuỗi là in hoa; Các ký tự còn lại của chuỗi là in thường. Gửi thông điệp chứa chuỗi đã được chuẩn hóa lên server theo định dạng “requestId;data”

d.Đóng socket và kết thúc chương trình

### Câu 5

Code: [UDP_STRING5.java](UDP_STRING5.java)

Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 808 . Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;06D6800D"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strInput", trong đó: requestId là chuỗi ngẫu nhiên duy nhất; strInput là chuỗi thông điệp cần xử lý.

c. Thực hiện loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của chúng. Gửi thông điệp lên server theo định dạng "requestId;strOutput", trong đó strOutput là chuỗi đã được xử lý ở trên

d. Đóng socket và kết thúc chương trình.

### Câu 6

Code: [UDP_STRING6.java](UDP_STRING6.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi một thông điệp chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;9F8C2D3A".

b. Nhận một thông điệp từ server theo định dạng "requestId;data", với: requestId là chuỗi ngẫu nhiên duy nhất; data là một chuỗi ký tự cần xử lý. Ví dụ: "requestId; WEaCyQuNDIgTnzRMWnYzQvPFxrznYjknKkblbhxjbkNpMGVVTWyUzxaoSICQwHwPLNK"

c. Xử lý chuỗi bằng cách đếm số lượng ký tự và gom chúng lại theo định dạng "số_lần_ký_tự". Gửi kết quả về server theo định dạng: "requestId;processedData". Ví dụ: "requestId;3W1E2a2C2y3Q1u3N1D2I1g2T4n4z1R2M2Y1v2P1F3x1r2j3k2K3b1l1h1p1G2V1U1o1S2w1H1L"

d. Đóng socket và kết thúc chương trình.

### Câu 7

Code: [UDP_STRING7.java](UDP_STRING7.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: ";B15DCCN007;AB12CD34"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;data", với:

requestId là chuỗi ngẫu nhiên duy nhất.

data là một chuỗi ký tự cần xử lý.

Ví dụ: "AB12CD34;hellooo"

c. Đếm số lần xuất hiện của từng ký tự trong chuỗi và sắp xếp theo tần suất giảm dần. Nếu hai ký tự có cùng tần suất, ký tự xuất hiện trước trong bảng chữ cái sẽ được xếp trước. Gửi thông điệp lên server theo định dạng  "requestId;char1:count1,char2:count2,...,charN:countN".

Ví dụ: Với data = "hellooo", kết quả là: "AB12CD34;o:3,l:2,e:1,h:1"

d. Đóng socket và kết thúc chương trình.

### Câu 8

Code: [UDP_STRING8.java](UDP_STRING8.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: ";B15DCCN008;CD34EF56"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;data", với:

requestId là chuỗi ngẫu nhiên duy nhất.

data là một chuỗi ký tự chứa nhiều từ, được phân cách bởi dấu cách.

Ví dụ: "CD34EF56;This is an example"

c. Phân tích chuỗi thành các từ, sau đó kiểm tra từ nào có toàn bộ ký tự là nguyên âm (a, e, i, o, u). Gửi thông điệp lên server theo định dạng "requestId;word1,word2,...,wordN", trong đó word1,word2,... là các từ thỏa mãn điều kiện.

Ví dụ: Với data = "This is an example", kết quả là: "CD34EF56;is,an"

d. Đóng socket và kết thúc chương trình.

### Câu 9

Code: [UDP_STRING9.java](UDP_STRING9.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 808. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: ";B15DCCN009;EF56GH78"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;data", với:

requestId là chuỗi ngẫu nhiên duy nhất.

data là một chuỗi ký tự chứa nhiều từ, được phân cách bởi dấu cách.

Ví dụ: "EF56GH78;The quick brown fox"

c. Sắp xếp các từ trong chuỗi theo thứ tự từ điển ngược (z đến a) và gửi thông điệp lên server theo định dạng "requestId;word1,word2,...,wordN".

Ví dụ: Với data = "The quick brown fox", kết quả là: "EF56GH78;quick,fox,brown,The"

d. Đóng socket và kết thúc chương trình.

## UDP Object

### Câu 1

Code: [UDP_OBJECT1.java](UDP_OBJECT1.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 809. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:

Đối tượng trao đổi là thể hiện của lớp UDP.Student được mô tả:

Tên đầy đủ lớp: UDP.Student

Các thuộc tính: id String,code String, name String, email String

02 Hàm khởi tạo:

public Student(String code)

public Student(String id, String code, String name, String email)

Trường dữ liệu: private static final long serialVersionUID = 20171107

Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Student từ server. Trong đó, các thông tin được thiết lập gồm id và name.

c. Yêu cầu:

Chuẩn hóa tên theo quy tắc: Chữ cái đầu tiên in hoa, các chữ cái còn lại in thường và gán lại thuộc tính name của đối tượng

Tạo email ptit.edu.vn từ tên người dùng bằng cách lấy tên và các chữ cái bắt đầu của họ và tên đệm. Ví dụ: nguyen van tuan nam -> namnvt@ptit.edu.vn. Gán giá trị này cho thuộc tính email của đối tượng nhận được

Gửi thông điệp chứa đối tượng xử lý ở bước c lên Server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Customer đã được sửa đổi.

d.Đóng socket và kết thúc chương trình.

### Câu 2

Ghi chú ngoài đề: Không giải câu này theo yêu cầu vì đề thiếu dữ liệu năm sinh.

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 809. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:

Đối tượng trao đổi là thể hiện của lớp UDP.Employee được mô tả:

Tên đầy đủ lớp: UDP.Employee

Các thuộc tính: id (String), name (String), salary (double), hireDate (String)

Hàm khởi tạo: public Employee(String id, String name, double salary, String hireDate)

Trường dữ liệu: private static final long serialVersionUID = 20261107L

Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B23DCCN006;ITleSdqV"

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Employee từ server. Trong đó, các thuộc tính id, name, salary và hireDate đã được thiết lập sẵn.

c. Thực hiện:

Chuẩn hóa name: viết hoa chữ cái đầu của mỗi từ, ví dụ "john doe" thành "John Doe".

Tăng salary: tăng x% lương, với x bằng tổng các chữ số của năm sinh.

Chuyển đổi hireDate từ định dạng yyyy-mm-dd sang dd/mm/yyyy. Ví dụ: "2023-07-15" thành "15/07/2023".

Gửi lại đối tượng đã được chuẩn hóa về server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Employee đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.

### Câu 3

Code: [UDP_OBJECT3.java](UDP_OBJECT3.java)

Thông tin khách hàng được yêu cầu thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:

Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong -> DUONG, Nguyen Van Hai

Ngày sinh của khách hàng đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 -> 11/10/2012

Tài khoản khách hàng được tạo từ các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong -> nvhduong

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 809. Yêu cầu là xây dựng một chương trình client giao tiếp với server theo mô tả sau:

Đối tượng trao đổi là thể hiện của lớp UDP.Customer được mô tả như sau

Tên đầy đủ của lớp: UDP.Customer

Các thuộc tính: id String, code String, name String, , dayOfBirth String, userName String

Một Hàm khởi tạo với đầy đủ các thuộc tính theo thứ tự được liệt kê ở trên

Trường dữ liệu: private static final long serialVersionUID = 20151107;

Thực hiện giao tiếp với server theo các bước sau:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Customer từ server. Trong đó, các thuộc tính id, code, name,dayOfBirth đã được thiết lập sẵn.

c. Yêu cầu thay đổi thông tin các thuộc tính như yêu cầu ở trên và gửi lại đối tượng khách hàng đã được sửa đổi lên server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Customer đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.

### Câu 4

Code: [UDP_OBJECT4.java](UDP_OBJECT4.java)

Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:

Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: “lenovo thinkpad T520” bị chuyển thành “T520 thinkpad lenovo”

Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 809. Yêu cầu là xây dựng một chương trình client giao tiếp với server để gửi/nhận các sản phẩm theo mô tả dưới đây:

Đối tượng trao đổi là thể hiện của lớp Product được mô tả như sau

Tên đầy đủ của lớp: UDP.Product

Các thuộc tính: id String, code String, name String, quantity int

Một hàm khởi tạo có đầy đủ các thuộc tính theo thứ tự được liệt kê ở trên

Trường dữ liệu: private static final long serialVersionUID = 20161107;

Yêu cầu Giao tiếp với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Product từ server. Trong đối tượng này, các thuộc tính id, name và quantity đã được thiết lập giá trị.

c. Sửa các thông tin sai của đối tượng về tên và số lượng như mô tả ở trên và gửi đối tượng vừa được sửa đổi lên server theo cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Product đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.

### Câu 5

Code: [UDP_OBJECT5.java](UDP_OBJECT5.java)

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 809. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:

Đối tượng trao đổi là thể hiện của lớp UDP.Book được mô tả:

Tên đầy đủ lớp: UDP.Book

Các thuộc tính: id (String), title (String), author (String), isbn (String), publishDate (String)

Hàm khởi tạo: public Book(String id, String title, String author, String isbn, String publishDate)

Trường dữ liệu: private static final long serialVersionUID = 20251107L

Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B23DCCN005;eQkvAeId"

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Book từ server. Trong đó, các thuộc tính id, title, author, isbn, và publishDate đã được thiết lập sẵn.

c. Thực hiện:

Chuẩn hóa title: viết hoa chữ cái đầu của mỗi từ.

Chuẩn hóa author theo định dạng "Họ, Tên".

Chuẩn hóa mã ISBN theo định dạng "978-3-16-148410-0"

Chuyển đổi publishDate từ yyyy-mm-dd sang mm/yyyy.

Gửi đối tượng đã được chuẩn hóa về server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Book đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.
