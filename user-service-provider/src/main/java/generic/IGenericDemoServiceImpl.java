package generic;

import java.util.Arrays;
import java.util.List;

public class IGenericDemoServiceImpl implements IGenericDemoService {

    @Override
    public List<Address> getPersonAddressList(String name) {
        if (name.equalsIgnoreCase("张三")) {
            return Arrays.asList(
                    new Address().setNo(111).setName("a街道").setCity("杭州市"),
                    new Address().setNo(222).setName("b街道").setCity("南京市"));
        }
        else  {
            return
                    Arrays.asList(
                            new Address().setNo(333).setName("c街道").setCity("杭州市"),
                            new Address().setNo(444).setName("d街道").setCity("南京市"));
        }
    }
}
