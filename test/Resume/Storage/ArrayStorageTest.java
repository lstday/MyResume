//package Resume.Storage;
//
//import Webapp.Storage.ArrayStorage;
//import Webapp.model.Contact;
//import Webapp.model.ContactType;
//import Webapp.model.Resume;
//import org.junit.Assert;
//import org.junit.Before;
//
///**
// * Created by lstday
// * 29.10.15.
// */
//public class ArrayStorageTest {
//    private static Resume R1, R2, R3;
//
//    private ArrayStorage storage = new ArrayStorage();
//
//
//    @Before
//    public void before() {
//        storage.clear();
//        storage.save(R1);
//        storage.save(R2);
//        storage.save(R3);
//    }
//
//    static {
//        R1 = new Resume("fullname1", "location1");
//        R1.addContact(new Contact(ContactType.EMAIL, "a@a.a"));
//        R1.addContact(new Contact(ContactType.MOBILE, "7-77-77"));
//        R2 = new Resume("fullname2", null);
//        R2.addContact(new Contact(ContactType.SKYPE, "skype"));
//        R2.addContact(new Contact(ContactType.MOBILE, "1-11-11"));
//        R3 = new Resume("fullname3", null);
//    }
//
//    @org.junit.Test
//    public void testClear() throws Exception {
//
//    }
//
//    @org.junit.Test
//    public void testSave() throws Exception {
//
//    }
//
//    @org.junit.Test
//    public void testLoad() throws Exception {
//
//    }
//
//    @org.junit.Test
//    public void testDelete() throws Exception {
//        storage.delete(R1.getUuid());
//        Assert.assertEquals(2, storage.size());
//        Assert.assertEquals(null, storage.load(R1.getUuid()));
//    }
//
//    @org.junit.Test
//    public void testGetAllSorted() throws Exception {
//
//    }
//
//    @org.junit.Test
//    public void testSize() throws Exception {
//        Assert.assertEquals(3, storage.size());
//    }
//
//    @org.junit.Test
//    public void testUpdate() throws Exception {
//
//    }
//}