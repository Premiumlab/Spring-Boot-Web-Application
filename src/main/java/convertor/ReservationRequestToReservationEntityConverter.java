package convertor;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.learning.entity.ReservationEntity;
import com.linkedin.learning.model.request.ReservationRequest;

//This class will take in a request body from a rest API call and convert it to a reservation entity so that we can save it
public class ReservationRequestToReservationEntityConverter
		implements Converter<ReservationRequest, ReservationEntity> {

	@Override
	public ReservationEntity convert(ReservationRequest source) {
		// TODO Auto-generated method stub
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getChekout());

		if (null != source.getId())
			reservationEntity.setId(source.getId());
		return reservationEntity;
	}

}
