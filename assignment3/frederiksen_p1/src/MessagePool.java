import java.security.SecureRandom;

public class MessagePool {
    private String[] pool;
    SecureRandom random;

    public MessagePool(String[] pool) {
        this.pool = pool;

        random = new SecureRandom();
    }

    public String fetchRandom() {
        int i = random.nextInt(pool.length);
        return pool[i];
    }
}
