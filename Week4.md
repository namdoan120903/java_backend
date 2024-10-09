# MySQL
    - Cấu trúc vật lí: Tệp dữ liệu, tệp log, binary log, data dictionary
    - Parser: phân tích và dịch các câu truy vấn sql, kiểm tra syntax, sinh cây phân tích parse tree
    - Optimizer: tối ưu hóa câu truy vấn trước khi thực thi, đảm bảo hiệu suất tốt nhất
        + Lựa chọn thứ tự duyệt bảng theo thứ tự bảng ghi, index, điều kiện where
        + Chọn loại JOIN: lựa chọn cách join có chi phi thấp nhất
        + Chọn chỉ mục:
        + Chuyển đổi câu truy vấn
    - Storage Engine: Lưu trữ và quản lí dữ liệu vật lí, hỗ trợ nhiều loại khác nhau
        + InnoDB: hỗ trợ ACID, khôi phục, kiểm soát phiên bản, 
        + Memory: lưu dữ liệu trong ram, tăng tốc độ, chỉ phù hợp cho lưu trữ tạm thời
# SQL Databases
    - MySQL: Hỗ trợ ACID, giao dịch mạnh mẽ, phù hợp với các ứng dụng web và doanh nghiệp.
    - PostgreSQL: Mạnh mẽ về giao dịch, hỗ trợ ACID, đồng thời hỗ trợ dữ liệu phi quan hệ với JSON.
    - Microsoft SQL Server: Hỗ trợ giao dịch, ACID, tích hợp sâu với hệ sinh thái Microsoft.
# NoSQL Databases
    - Không sử dụng cấu trúc bảng, quan hệ truyền thống thay vào đó là những cấu trúc linh hoạt hơn: document, key-value, graph
    - MongoDB: document-oriented, lưu trữ dữ liệu dưới dạng Json-like(Bson), linh hoạt, dễ mở rộng theo chiều ngang, phù hợp cho ứng dụng 
    không có cấu trúc hoặc cấu trúc thay đổi. Dễ mở rộng, không yêu cầu cấu trúc schema cố định, không hoàn toàn tuân theo ACID nhưng hỗ trợ BASE.
    - Redis: key-value, hoạt động chủ yếu trên ram, hiệu suất cao
    - Cassandra: NoSql phân tán, kiểu column-family, mở rộng và sẵn sàng cao, phù hợp hệ thống lớn, hỗ trợ BASE
# CAP
    - Sự cân bằng giữa ba thuộc tính:
    - C - Consistency (tính nhât quán): mọi node trong hệ thống sẽ có cùng 1 trạng thái dữ liệu sau khi giao dịch đc thực hiện
    - A - Availability (tính sẵn sàng): mọi yêu cầu phải nhận được phản hồi
    - P - Partition Tolerance (khả năng chịu lỗi phân vùng): Hệ thống có thể tiếp tục hoạt động ngay khi bị lỗi phân vùng
    - Một hệ thống phân tán chỉ có thể đạt được tối đa hai trong ba thuộc tính này.
# ACID
    - Đảm bảo sự toàn vẹn của các giao dịch
    - Atomicity (tính nguyên tử): một giao dịch phải được thực hiện hoàn toàn hoặc không gì cả
    - Consistency (tính nhất quán): dữ liệu phải nhất quán sau mỗi giao dịch
    - Isolation (tính cô lập): các giao dịch phải độc lập với nhau, không ảnh hưởng lẫn nhau
    - Durability (tính bền vững): sau khi giao dịch được commit, dữ liệu phải được lưu trữ vĩnh viễn
# BASE
    - Mô hình đặc trưng của các hệ thống NoSQL, đối lập với ACID
    - Basically Available: Hệ thống luôn phản hồi, không nhất thiết đảm bảo tính chính xác
    - Soft state: Trạng thái hệ thống có thể thay đổi theo thời gian, không cố định
    - Eventual consistency: dữ liệu dần trở nên nhất quán, không đảm bảo nhất quán sau mỗi lần ghi
# 3 dạng chuẩn của SQL databases

### Dạng chuẩn 1NF
    - Khi toàn bộ các miền giá trị chỉ chứa giá trị nguyên tử(không chứa mảng)
    - (1, [1,2,3]) tách về (1,1)(1,2)(1,3)
### Dạng chuẩn 2NF
    - Là 1NF, thuộc tính không khóa phụ thuộc hàm đầy đủ vào khóa chính
    - R = (ABCD), khóa chính AB, F=(AB=>C, AB=>D, B=>CD), do CD không phụ thuộc đầy đủ vào khóa chính AB nên ta tách
    R1(A,B) khóa chính AB, R2(B,C,D) khóa chính B
    - Có bảng order(cus_id, pro_id, name_cus, name_pro, total, price_pro, telephone) khóa chính là (cus_id, product_id)
    - Có quá nhiều trường phụ thuộc ko đầy đủ vào khóa chính nên tách:
        + order(cus_id, pro_id, total)
        + customer(cus_id, name_cus, telephone)
        + product(pro_id, name_pro, price)
### Dạng chuẩn 3NF
    - Là 2NF, không có phụ thuộc bắc cầu vào khóa chính
    - order(order_id, pro_id, name_pro), product(pro_id, name_pro, price) thì ta loại bỏ name_pro trong bảng order do nó phụ thuộc bắc cầu vào pro_id
### Tối ưu query
    - file week4.sql

