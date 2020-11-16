package codeforces.com.tasks.entityLockerTask;

import java.util.*;

public class AdsRepository {

    private final EntityLocker<String> locker;
    private final Map<String, Ad> repository = new HashMap<>();
    private final Random random = new Random();

    private AdsRepository(EntityLocker<String> locker) {
        this.locker = locker;
    }

    public void create(Ad ad){
        if (ad != null && !repository.containsKey(ad.getId())) {
            repository.put(ad.getId(), Ad.valueOf(ad.getId(), ad.getKeywords()));
        }
    }

    public void addKeyword(String id, String keyword) {
        locker.getLock(id);
        try {
            System.out.println("b - " + Thread.currentThread().getName());
            if (repository.containsKey(id)) {
                Ad ad = repository.get(id);
                var keywords = ad.getKeywords();
                keywords.add(keyword);
                callDb(keywords);
                ad.setKeywords(keywords);
            } else {
                throw new NoSuchElementException("Item with id " + id + "not exists");
            }
            System.out.println("e - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
                e.printStackTrace();
        } finally {
            locker.releaseLock(id);
        }
    }

    public void print() {
        repository.forEach( (id, item) -> System.out.println(item) );
    }

    private void callDb(Set<String> keywords) throws InterruptedException {
        var time = 10 + random.nextInt(50);
        Thread.sleep(time);
    }

    public static AdsRepository getInstance(EntityLocker<String> locker){
        return new AdsRepository(locker);
    }
}
