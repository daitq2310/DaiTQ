/**
 * Created by Quang Đại on 11/3/2016.
 */
public interface Subject {
    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifiObserver();
}
