import cn.xupt.entity.Parcel;
import cn.xupt.service.ParcelService;
import cn.xupt.serviceImpl.ParcelServiceImpl;

/**
 * Created by Admin on 2016/12/5.
 */

public class ParcelAddTest {

    public static void main(String[] args){
        Parcel parcel = new Parcel();
        ParcelService parcelService = new ParcelServiceImpl();
        String result = parcelService.parcelPub(parcel);
        System.out.println(result);
    }

}
