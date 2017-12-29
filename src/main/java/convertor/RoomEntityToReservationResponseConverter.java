package convertor;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.learning.entity.RoomEntity;
import com.linkedin.learning.model.Links;
import com.linkedin.learning.model.Self;
import com.linkedin.learning.model.response.ReservationResponse;
import com.linkedin.learning.rest.ResourceConstants;


public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice( Integer.valueOf(source.getPrice()) );
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}
	
	
	
}
