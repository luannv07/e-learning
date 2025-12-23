package id.luannv.e_learning.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum ErrorCode {

    // ===== COMMON =====
    UNCATEGORIZED_ERROR(500, "Đã xảy ra lỗi không xác định."),
    INVALID_PARAM(400, "Tham số không hợp lệ."),
    FIELD_BLANK(400, "Trường này không được để trống."),
    FIELD_TOO_LONG(400, "Giá trị nhập quá dài."),
    ENUM_INVALID(400, "Giá trị không nằm trong danh sách cho phép."),
    NOTHING_UP_TO_DATE(422, "Không có dữ liệu nào để cập nhật."),

    // ===== AUTH / USER =====
    USER_NOT_FOUND(404, "Không tìm thấy người dùng."),
    USER_ALREADY_EXISTS(409, "Người dùng đã tồn tại."),
    EMAIL_EXISTED(409, "Email đã tồn tại."),
    EMAIL_INVALID(400, "Email không hợp lệ."),
    USERNAME_EXISTED(409, "Tên đăng nhập đã tồn tại."),
    USERNAME_INVALID(400, "Tên đăng nhập không hợp lệ."),
    PASSWORD_INVALID(400, "Mật khẩu không hợp lệ."),
    UNAUTHORIZED(401, "Chưa đăng nhập hoặc token không hợp lệ."),
    FORBIDDEN(403, "Bạn không có quyền truy cập tài nguyên này."),

    // ===== STUDENT / TEACHER =====
    STUDENT_NOT_FOUND(404, "Không tìm thấy học viên."),
    TEACHER_NOT_FOUND(404, "Không tìm thấy giảng viên."),
    USER_STATUS_INVALID(400, "Trạng thái người dùng không hợp lệ."),

    // ===== COURSE =====
    COURSE_NOT_FOUND(404, "Không tìm thấy khóa học."),
    COURSE_ALREADY_PUBLISHED(400, "Khóa học đã được phát hành."),
    COURSE_NOT_PUBLISHED(400, "Khóa học chưa được phát hành."),
    COURSE_NAME_EXISTED(409, "Tên khóa học đã tồn tại."),
    COURSE_ENROLLMENT_CLOSED(400, "Khóa học đã đóng đăng ký."),

    // ===== LESSON / CONTENT =====
    LESSON_NOT_FOUND(404, "Không tìm thấy bài học."),
    LESSON_ORDER_INVALID(400, "Thứ tự bài học không hợp lệ."),
    CONTENT_EMPTY(400, "Nội dung bài học không được để trống."),

    // ===== ENROLLMENT =====
    ENROLLMENT_NOT_FOUND(404, "Không tìm thấy thông tin đăng ký khóa học."),
    ALREADY_ENROLLED(409, "Học viên đã đăng ký khóa học này."),
    NOT_ENROLLED(400, "Học viên chưa đăng ký khóa học."),

    // ===== REVIEW / PROGRESS =====
    REVIEW_NOT_FOUND(404, "Không tìm thấy đánh giá."),
    PROGRESS_INVALID(400, "Tiến độ học tập không hợp lệ.");

    Integer status;
    String message;
}
