# Tran Van Cuong --- 202416872
 
 
# GUIProject – Hướng dẫn sử dụng `run.bat`
 
## Yêu cầu hệ thống
 
- **Java JDK** 11 trở lên đã được cài đặt và thêm vào `PATH`
- **JavaFX SDK** đã được đặt trong thư mục `lib/` của dự án
- Hệ điều hành **Windows**
## Cấu trúc thư mục
 
```
GUIProject/
├── src/
│   └── hust/soict/hedspi/
│       ├── swing/       # Các file Java dùng AWT/Swing
│       └── javafx/      # Các file Java dùng JavaFX
├── lib/                 # JavaFX SDK (javafx.controls, javafx.fxml, ...)
├── bin/                 # Thư mục chứa file .class sau khi biên dịch (tự tạo)
└── run.bat              # Script chạy dự án
```
 
## Cách chạy
 
Mở **Command Prompt** hoặc **PowerShell**, di chuyển đến thư mục gốc của dự án rồi chạy:
 
```bat
.\run.bat
```
 
Script sẽ tự động:
1. Tạo thư mục `bin/` nếu chưa có
2. Biên dịch toàn bộ source code (cả Swing và JavaFX)
3. Hiển thị menu để chọn ứng dụng muốn chạy
## Menu lựa chọn
 
```
Please select the application to run:
1. AWTAccumulator
2. SwingAccumulator
3. NumberGrid
4. Painter (JavaFX)
5. Exit
```
 
| Lựa chọn | Ứng dụng | Mô tả |
|----------|----------|-------|
| `1` | AWTAccumulator | Ứng dụng tích lũy số dùng AWT |
| `2` | SwingAccumulator | Ứng dụng tích lũy số dùng Swing |
| `3` | NumberGrid | Lưới số dùng Swing |
| `4` | Painter | Ứng dụng vẽ dùng JavaFX |
| `5` | Exit | Thoát chương trình |
 
Nhập số tương ứng rồi nhấn **Enter** để chạy ứng dụng. Sau khi đóng ứng dụng, menu sẽ hiện lại để bạn chọn tiếp.

# AIMS Project – Hướng dẫn sử dụng `run.bat`
 
## Yêu cầu hệ thống
 
- **Java JDK** 11 trở lên
- Hệ điều hành **Windows**
## Cách chạy
 
Mở **Command Prompt** hoặc **PowerShell**, di chuyển đến thư mục gốc của dự án rồi chạy:
 
```bat
.\run.bat
```
 
Ứng dụng **AIMS** sẽ khởi động ngay lập tức.
 
## Lưu ý
 
Em đã đóng gói đầy đủ thư viện và tài nguyên cần thiết trong từng project, chỉ cần tải về và chạy lệnh `.\run.bat` là có thể sử dụng ngay, không cần cài đặt thêm ạ.
