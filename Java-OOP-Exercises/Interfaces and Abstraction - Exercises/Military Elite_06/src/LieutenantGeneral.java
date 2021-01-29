import java.util.List;

public interface LieutenantGeneral {
    List<PrivateImpl> getPrivates();

    void addPrivate(PrivateImpl priv);
}
