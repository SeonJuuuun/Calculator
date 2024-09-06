package level3;

public class AppException extends Exception{
    public AppException() {
        super("잘못된 입력입니다!");
        //TODO 꼼꼼한 예외 처리 해보기
    }
}
