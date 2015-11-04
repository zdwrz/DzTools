package dztools.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import dztools.model.LocationMain;

@ManagedBean(name="locationBean")
@SessionScoped
public class LocationBean implements Serializable{

	private static final long serialVersionUID = 2681670836838289817L;
	private MapModel markerModel;
	private String passcode;
	private String mapCenterStr;
	private String info;
	private boolean showMap;
	@PostConstruct
    public void init() {
		LocationMain main = JerseyLocation.getLocation();
		this.mapCenterStr = main.getLatitude() + ", " + main.getLongitude();
        markerModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(main.getLatitude(), main.getLongitude());
        Marker marker = new Marker(coord1, main.getCreatedBy());
        markerModel.addOverlay(marker);
        SimpleDateFormat isoFormat = new SimpleDateFormat("MM/dd/yyyy 'EST' HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        String date = isoFormat.format(new Date(main.getCreateDate()));
        info = "Last Updated: "+ date + " From: "+ main.getCreatedBy();
    }
	public void actionCheckPasscode(){
		if("0216".equals(passcode)){
			showMap = true;
		}
	}
	public void actionRefresh(){
		this.init();
	}
	public MapModel getMarkerModel() {
		return markerModel;
	}
	public void setMarkerModel(MapModel markerModel) {
		this.markerModel = markerModel;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public boolean isShowMap() {
		return showMap;
	}

	public void setShowMap(boolean showMap) {
		this.showMap = showMap;
	}
	public String getMapCenterStr() {
		return mapCenterStr;
	}
	public void setMapCenterStr(String mapCenterStr) {
		this.mapCenterStr = mapCenterStr;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
