# Exception
    - Exception là một sự kiện xảy ra trong quá trình thực thi một chương trình Java, nó làm phá vỡ cái flow (luồng xử lý) bình thường của một chương trình
    - Trong Java có 2 loại exception: checked và unchecked
    - Tất cả các checked exception được kế thừa từ lớp Exception ngoại trừ lớp RuntimeException
    - RuntimeException là lớp cơ sở của tất cả các lớp unchecked exception
### Checked exception: 
    - Là loại exception xảy ra trong lúc compile time. Loại exception này không thể bỏ qua được trong quá trình compile, bắt buộc ta phải handle nó.
    - FileNotFoundException: được kiểm tra lúc compile time, nếu file không tồn tại sẽ ném ra 1 FileNotFoundException
### Unchecked exception:
    - Là loại exception xảy ra tại thời điểm thực thi chương trình, Loại exception này được bỏ qua trong quá trình compile, không bắt buộc ta phải handle nó
    - Vd: NullPointException, ArthimeticException,..
    - Khi một biến có giá trị là null, khi thực hiện hoạt động nào với biến đó (sout,..) sẽ xảy ra ngoại lệ NullPointException
# Exception Handling
    - Một cơ chế xử lý các lỗi runtime để có thể duy trì luồng bình thường của ứng dụng.
    - Quá trình xử lý exception được gọi là catch exception, nếu Runtime System không xử lý được ngoại lệ thì chương trình sẽ kết thúc
    - Sử dụng khối lệnh try catch để bắt và xử lí cac exception
    - ArithmeticException: khi người dùng cố chia cho 1 giá trị bằng 0 thì sẽ xảy ra ngoại lệ này, chúng ta nên kiểm tra giá trị chia trước khi thực hiện
    - NullPointException: Khi khởi tạo 1 list nhưng chưa khởi tạo, khi in ra độ dài của list đó thì ngoại lệ sẽ xảy ra, nên khơi tạo bằng new ArrayList<>() trước
    - FileNotFoundException: Kiểm tra đường dẫn đầu vào.

# Concurrency
### Luồng chạy ngầm sử dụng Runnable
    - Thread là một tiến trình con (sub-process). Một đơn vị xử lý nhỏ nhất của máy tính có thể thực hiện một công việc riêng biệt
    - Multi-thread là một tiến trình thực hiện nhiều luồng đồng thời
    - Khai báo 1 lớp mới ipl interface Runnable, ghi đè phương thức run và viết lệnh ra muốn thực hiện
    - Tạo 1 đối tượng cho lớp trên, tạo 1 đối tượng Thread và truyền vào đối tượng Runnable vừa tạo, gọi phương thức start() để chạy
    - /src/main/java/javaRunnableDemo.java:
        - trong phương thức run, khởi tạo vòng for để in ra thứ tự, sau môi lần lặp cho Thread.sleep(10ms)
        - Khi gọi 2 đối tượng khác nhau, khởi tạo 2 thread khác nhau thì khi start cả 2 thread sẽ chạy đồng thơi
### ThreadPool 
    - ThreadPool được dùng để giới hạn số lượng Thread được chạy bên trong ứng dụng của chúng ta trong cùng một thời điểm ví dụ:
    - Fixed thread pool: giới hạn số lượng tối đa của các Thread được tạo ra để thực thi các tas. Các task khác đang chờ trong hàng đợi.
    - Single-threaded pool: chỉ giữ một Thread thực thi một nhiệm vụ một lúc.
    - Executor là một đối tượng chịu trách nhiệm quản lý các luồng và thực hiện các tác vụ Runnable được yêu cầu xử lý
    - /src/main/java/ThreadPool.java:
        - lớp WorkThread ipl Runnable, phương thức run() in ra màn hình "start", chờ 60ms và in tiếp "finish"
        - SingleThread: khởi tạo 1 Executor kiểu newSingleThreadExecutor(), trong vòng for ta khởi tạo các Runnable và cho execute nó thì thứ tự thực hiện sẽ lần lượt cho dù phải đợi
        - FixedThread: Khởi tạo 1 Executor kiểu newFixedThreadPool(num_threads), khi chạy tương tự như trên thì trong 1 thời điểm sẽ có 5 thread được chạy đồng thời
### Lock
    - Cơ chế ngăn nhiều luồng truy cập vào tài nguyên dùng chung, đảm bảo chỉ có 1 luồng thực hiện nó vào 1 thời điểm
    - Ví dụ: có biến count, thực thi đoạn mã count++, chúng ta nên dùng lock cho phương thức này để tránh sự sai lệch
### Atomic Integer
    - Kiểu dữ liệu cung cấp thao tác an toàn luồng mà không cần phải sử dụng khóa
    - khai báo 1 biến count kiểu AtomicInteger, thực hiên cac phép toàn tăng giảm đơn giản mà không cần sử dụng khóa: incrementAndGet(), decrementAndGet()
### Concurrent HashMap
    - Cho phép nhiều luồng đọc ghi vào map cùng 1 lúc mà không gây lỗi dữ liệu
    - Phù hợp cho ứng dụng cần nhiều luồng truy cập vào map đồng thời
### Race Condition
    - Race condition xảy ra khi nhiều luồng truy cập và thay đổi cùng một tài nguyên đồng thời mà không có sự đồng bộ
    - Các luồng có thể đua nhau để thực hiện các thao tác trên tài nguyên trước khi luồng kia hoàn thành
    - Ví dụ như biến count ở trên, nếu nhiều luồng thực hiện phương thức count++ 1 luc sẽ xảy ra sai lệch, nên sử dụng lock hoặc atomicInteger để đảm bảo an toàn
### Virtual Threads
    - Luồng ảo nhẹ, không tiêu tốn tài nguyên như luồng truyền thống
    - Tối ưu hiệu suất hệ thống
    - Thread.startVirtualThread(()->{}) khởi tạo 1 luồng ảo mới

# Json

### Json simple
    - Tạo project maven, add dependency json-simple
    - Sử dụng JSONParser để parser String sang kiểu JsonObject
    - Từ jsonObject thu được có thể sử dụng get(key) để lấy ra giá trị tương ứng, toString để chuyển đổi về kiểu String
### Gson
    - add denpendency gson
    - Khởi tạo đối tượng Gson
    - Tạo 1 đối tượng Employee, sử dụng gson.toJson(object) để thu được chuỗi json kiểu string
    - Chuyển đổi từ json về object tương ứng Employee employee = gson.fromJson(json, Employee.class);
    