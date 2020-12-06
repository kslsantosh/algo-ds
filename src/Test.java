import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalDateTime.now());
    }
}
