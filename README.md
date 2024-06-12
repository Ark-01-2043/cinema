# Microservices for Cinema Management System

## Chủ đề

Hệ thống microservices cho quản lý rạp chiếu phim.

## Báo cáo

https://docs.google.com/document/d/1WMPcJNhIKxfV_XbxTKpBYOZguSVFbRDnl0AdJC-kMS0/edit

## Thông tin nhóm

Thành viên:

- Hoàng Xuân Lương - B20DCCN412
- Đỗ Như Phan Anh - B20DCCN051
- Nguyễn Công Nhật Minh - B20DCCN435

## Công nghệ sử dụng

- Spring Boot (Java)
- React (JavaScript)
- Spring Cloud
- Docker
- Kubernetes

## Kiến trúc

Hệ thống sử dụng kiến trúc microservices, được triển khai bằng Spring Cloud. Các dịch vụ chính bao gồm:

1. Config Server
2. Service Registry (Eureka)
3. API Gateway (Spring Cloud Gateway)
4. Zipkin Server (Tracing)

Các dịch vụ chức năng:

- Rap Service
- Phongchieu Service
- Phim Service
- Ghe Service
- DoiDiem Service
- Khunggio Service
- Lichchieu Service
- Ve Service
- Dichvu Service
- Hoadon Service
- Thanhvien Service

  ![hdv](https://github.com/jnp2018/midproj-412051435/assets/89636817/aa91ab78-c45a-4657-9ea2-21c91e8e509b)


## Chức năng chính

1. Đăng ký và đăng nhập: Cho phép khách hàng đăng ký tài khoản mới và đăng nhập vào hệ thống.
2. Đổi điểm thưởng lấy quà tặng: Khách hàng có thể đổi điểm thưởng tích lũy từ việc mua vé để nhận quà tặng.
3. Đặt vé: Khách hàng có thể chọn phim, suất chiếu, ghế và đặt vé trước.
4. Thanh toán: Hỗ trợ thanh toán các vé đã đặt thông qua các phương thức thanh toán trực tuyến.

## Cài đặt môi trường

1. **Backend (Spring Boot)**

   - Clone repository từ GitHub.
   - Cài đặt Java Development Kit (JDK) và Maven.
   - Import project vào IDE (IntelliJ IDEA hoặc Eclipse).
   - Chạy từng dịch vụ Spring Boot (config server, service registry, các dịch vụ chức năng) theo thứ tự.

2. **Frontend (React)**

   - Clone repository từ GitHub.
   - Cài đặt Node.js và npm.
   - Mở terminal, di chuyển vào thư mục frontend và chạy lệnh `npm install` để cài đặt các thư viện cần thiết.
   - Sau khi cài đặt xong, chạy lệnh `npm start` để khởi động ứng dụng.

3. **Docker (Tùy chọn)**
   - Nếu bạn muốn triển khai hệ thống trong môi trường Docker, hãy sử dụng Docker Compose để triển khai các dịch vụ.
   - Tạo một file `docker-compose.yml` và cấu hình các dịch vụ cần thiết như config server, service registry, các dịch vụ chức năng, frontend, và database (nếu cần).
   - Chạy lệnh `docker-compose up` để bắt đầu triển khai hệ thống.

## Triển khai

- Sau khi cài đặt môi trường hoàn tất, triển khai các dịch vụ lên môi trường sản phẩm.
- Cấu hình và kết nối các dịch vụ với nhau thông qua các cổng và endpoints tương ứng.
- Kiểm tra tính ổn định và hiệu suất của hệ thống trước khi đưa vào sử dụng thực tế.
