# Shell Linux

### Command cơ bản
    - cd: di chuyên đến thư mục khác : cd/home/namdv
    - ls: liệt kê tệp và thư mục trong đường dẫn hiện tại: ls 
    - cp: copy thư mục đến đích: cp data.txt /home
    - mv: di chuyển thư mục, file đến nơi chỉ định hoặc đổi tên: mv data.txt /home , mv data.txt namdoan.txt
    - mkdir: tạo thư mục mới : mkdir java
    - touch: tạo file mới: touch data.txt
    - cat: đọc file : cat data.txt
    - head: đọc dòng đầu tiên của file: head -n 5 data.txt
    - echo: ghi vào file: echo "Hello" > data.txt ghi đè nên nội dung đã tồn tại, echo "Hello" >> data.txt thêm vào cuối của tệp
### Lệnh liên quan đến quyền
    - groupadd, useradd: tạo group và user mới
    - chmod: thay đổi quyền của tệp và thư mục: chmod 755 data.txt (đọc ghi thực thi cho chủ sở hữu, nhóm, người dùng khác)
    - giá trị trong chmod: read-4, write-2, excute-1
    - chown : thay đổi quyền sở hữu của tệp hoặc thư mục: chown user:group data.txt
    - ls -l: liệt kê chi tiết các file bao gồm cả thông tin về quyền và sở hữu
### Thực hiện lệnh song song
    - sử dụng | để kết nối các lệnh với nhau, kết quả lệnh trước là đầu vào lệnh sau
    - cat data.txt | wc -l : đếm số dòng trong tệp
    - cat data.txt | grep "a" : tìm các vị trí có kí tự a
    - cat data.txt | head -2 : hiển thị 2 dòng đầu của tệp
    - cat data.txt | tail -2 : hiển thị 2 dòng cuối của tệp
### Vim
    - vim: vim data.txt : tạo hoặc mở tệp đã có
    - vừa vào đang ở chế độ command, ấn i để chỉnh sửa, esc để trở về
    - :w để lưu, :wq lưu và thoát
### Quản lý tiến trình
    - htop: hiển thị các tiến trình hệ thống
    - ps aux: hiển thị các tiến trình đang chạy của hệ thống
    - kill -9 [PID]: buộc dừng tiến trình với PID

# Rest Api 
    - Tạo project Spring boot
    - Tạo lớp Controller với annotation @RestController
    - Sử dụng @GetMapping("/ping") để xác định đường dẫn và phương thức GET
    - Hàm trả về String "Pong"
    - truy cập localhost:8080/ping ta được response trả về là pong
# Docker
    - Docker là nền tảng giúp deploy, run application với container
    - Môi trường độc lập và tách biệt để khởi chạy, khi cần deploy sever nào chỉ cần run container
    - Các lệnh cơ bản:
        - docker image ls
        - docker image rm <id / tên image>
        - docker ps -a
        - docker stop <tên container / id>
        - docker run -d <tên image> -p port:portcontaine
        - docker build -t <tên image>: build image từ dockerfile 
### Dockerfile
    - file config để build Project ra image
    - dùng 1 image cơ bản để xây dựng, sau đó chồng thêm các lớp tiếp theo
    - FROM : chỉ định image gốc
    - RUN: 1 lệnh khi build image, sử dụng để cài đặt các package
    - COPY, ADD : sao chép file vào thư mục của container
    - WORKDIR: chỉ định thư mục làm việc
    - EXPOSE: khai báo port lắng nghe của image
    - ENTRYPOINT: lệnh và đối số cho container thực thi
    - /Dockerfile:
        - Chỉ định môi trường build: FROM maven:3.9.4-eclipse-temurin-21-alpine làm image gốc, chỉ định thư mục làm việc và copy tất cả vào
        - Build ứng dụng thành file jar bằng maven
        - Chỉ định môi trường run: FROM eclipse-temurin:21-jre-alpine
        - Copy file jar từ bước build 
        - Chỉ định port 8080
        - Chạy ứng dụng bằng java -jar myapp.jar
### docker-compose
    - file yml để config, su dụng để chạy nhiều container cùng 1 lúc
    - thiết lập port để chạy ngoài và trong container
    - docker-compose up -d: chạy 
    - docker-compose down