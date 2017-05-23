/**
 * 
 */
package com.fexco.pcode.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Sachin
 *
 */
@JsonInclude(Include.NON_NULL)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String addressline1;
    private String addressline2;
    private String addressline3;
    private String addressline4;
    private String addressline5;
    private String addressline6;
    private String addressline7;
    private String addressline8;
    private String addressline9;
    private String addressline10;
    private String summaryline;
    private String organisation;
    private String departmentname;
    private String buildingname;
    private String subbuildingname;
    private String number;
    private String premise;
    private String dependentstreet;
    private String street;
    private String doubledependentlocality;
    private String dependentlocality;
    private String posttown;
    private String county;
    private String postcode;
    private String country;
    private String pobox;
    private String recodes;
    private Boolean morevalues;
    private Integer nextpage;
    private Integer totalresults;
    private String latitude;
    private String longitude;
    private String uniquedeliverypointreferencenumber;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the addressline1
	 */
	public String getAddressline1() {
		return addressline1;
	}
	/**
	 * @param addressline1 the addressline1 to set
	 */
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	/**
	 * @return the addressline2
	 */
	public String getAddressline2() {
		return addressline2;
	}
	/**
	 * @param addressline2 the addressline2 to set
	 */
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	/**
	 * @return the addressline3
	 */
	public String getAddressline3() {
		return addressline3;
	}
	/**
	 * @param addressline3 the addressline3 to set
	 */
	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}
	/**
	 * @return the summaryline
	 */
	public String getSummaryline() {
		return summaryline;
	}
	/**
	 * @param summaryline the summaryline to set
	 */
	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}
	/**
	 * @return the organisation
	 */
	public String getOrganisation() {
		return organisation;
	}
	/**
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	/**
	 * @return the buildingname
	 */
	public String getBuildingname() {
		return buildingname;
	}
	/**
	 * @param buildingname the buildingname to set
	 */
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	/**
	 * @return the premise
	 */
	public String getPremise() {
		return premise;
	}
	/**
	 * @param premise the premise to set
	 */
	public void setPremise(String premise) {
		this.premise = premise;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the dependentlocality
	 */
	public String getDependentlocality() {
		return dependentlocality;
	}
	/**
	 * @param dependentlocality the dependentlocality to set
	 */
	public void setDependentlocality(String dependentlocality) {
		this.dependentlocality = dependentlocality;
	}
	/**
	 * @return the posttown
	 */
	public String getPosttown() {
		return posttown;
	}
	/**
	 * @param posttown the posttown to set
	 */
	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}
	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the pobox
	 */
	public String getPobox() {
		return pobox;
	}
	/**
	 * @param pobox the pobox to set
	 */
	public void setPobox(String pobox) {
		this.pobox = pobox;
	}
	/**
	 * @return the departmentname
	 */
	public String getDepartmentname() {
		return departmentname;
	}
	/**
	 * @param departmentname the departmentname to set
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	/**
	 * @return the subbuildingname
	 */
	public String getSubbuildingname() {
		return subbuildingname;
	}
	/**
	 * @param subbuildingname the subbuildingname to set
	 */
	public void setSubbuildingname(String subbuildingname) {
		this.subbuildingname = subbuildingname;
	}
	/**
	 * @return the dependentstreet
	 */
	public String getDependentstreet() {
		return dependentstreet;
	}
	/**
	 * @param dependentstreet the dependentstreet to set
	 */
	public void setDependentstreet(String dependentstreet) {
		this.dependentstreet = dependentstreet;
	}
	/**
	 * @return the doubledependentlocality
	 */
	public String getDoubledependentlocality() {
		return doubledependentlocality;
	}
	/**
	 * @param doubledependentlocality the doubledependentlocality to set
	 */
	public void setDoubledependentlocality(String doubledependentlocality) {
		this.doubledependentlocality = doubledependentlocality;
	}
	/**
	 * @return the recodes
	 */
	public String getRecodes() {
		return recodes;
	}
	/**
	 * @param recodes the recodes to set
	 */
	public void setRecodes(String recodes) {
		this.recodes = recodes;
	}
	/**
	 * @return the morevalues
	 */
	public Boolean getMorevalues() {
		return morevalues;
	}
	/**
	 * @param morevalues the morevalues to set
	 */
	public void setMorevalues(Boolean morevalues) {
		this.morevalues = morevalues;
	}
	/**
	 * @return the nextpage
	 */
	public Integer getNextpage() {
		return nextpage;
	}
	/**
	 * @param nextpage the nextpage to set
	 */
	public void setNextpage(Integer nextpage) {
		this.nextpage = nextpage;
	}
	/**
	 * @return the totalresults
	 */
	public Integer getTotalresults() {
		return totalresults;
	}
	/**
	 * @param totalresults the totalresults to set
	 */
	public void setTotalresults(Integer totalresults) {
		this.totalresults = totalresults;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the addressline4
	 */
	public String getAddressline4() {
		return addressline4;
	}
	/**
	 * @param addressline4 the addressline4 to set
	 */
	public void setAddressline4(String addressline4) {
		this.addressline4 = addressline4;
	}
	/**
	 * @return the addressline5
	 */
	public String getAddressline5() {
		return addressline5;
	}
	/**
	 * @param addressline5 the addressline5 to set
	 */
	public void setAddressline5(String addressline5) {
		this.addressline5 = addressline5;
	}
	/**
	 * @return the addressline6
	 */
	public String getAddressline6() {
		return addressline6;
	}
	/**
	 * @param addressline6 the addressline6 to set
	 */
	public void setAddressline6(String addressline6) {
		this.addressline6 = addressline6;
	}
	/**
	 * @return the addressline7
	 */
	public String getAddressline7() {
		return addressline7;
	}
	/**
	 * @param addressline7 the addressline7 to set
	 */
	public void setAddressline7(String addressline7) {
		this.addressline7 = addressline7;
	}
	/**
	 * @return the addressline8
	 */
	public String getAddressline8() {
		return addressline8;
	}
	/**
	 * @param addressline8 the addressline8 to set
	 */
	public void setAddressline8(String addressline8) {
		this.addressline8 = addressline8;
	}
	/**
	 * @return the addressline9
	 */
	public String getAddressline9() {
		return addressline9;
	}
	/**
	 * @param addressline9 the addressline9 to set
	 */
	public void setAddressline9(String addressline9) {
		this.addressline9 = addressline9;
	}
	/**
	 * @return the addressline10
	 */
	public String getAddressline10() {
		return addressline10;
	}
	/**
	 * @param addressline10 the addressline10 to set
	 */
	public void setAddressline10(String addressline10) {
		this.addressline10 = addressline10;
	}
	/**
	 * @return the uniquedeliverypointreferencenumber
	 */
	public String getUniquedeliverypointreferencenumber() {
		return uniquedeliverypointreferencenumber;
	}
	/**
	 * @param uniquedeliverypointreferencenumber the uniquedeliverypointreferencenumber to set
	 */
	public void setUniquedeliverypointreferencenumber(String uniquedeliverypointreferencenumber) {
		this.uniquedeliverypointreferencenumber = uniquedeliverypointreferencenumber;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
    
    

}
