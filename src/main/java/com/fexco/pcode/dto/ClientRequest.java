/**
 * 
 */
package com.fexco.pcode.dto;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
@Document(collection="client_request")
public class ClientRequest {

	private String endPointName;
	private String postCode;
	private String country;
	private String requestId;
	private int lines;
	private String include;
	private String exclude;
	private String format;
	private String identifier;
	private String page;
	private String addtags;
	private boolean postCodeOnly=true;
	private RequestStatus status;
	private String comment;
	private String derivedKey;
	private String clientHost;
	private String host;
	
	/**
	 * @return the derivedKey
	 */
	public String getDerivedKey() {
		return derivedKey;
	}
	/**
	 * @param derivedKey the derivedKey to set
	 */
	public ClientRequest derivedKey(String derivedKey) {
		this.derivedKey = derivedKey;
		return this;
	}
	public String getRequestId() {
		return requestId;
	}
	public ClientRequest requestId(String requestId) {
		this.requestId = requestId;
		return this;
	}
	public int getLines() {
		return lines;
	}
	public ClientRequest lines(int lines) {
		this.lines = lines;
		return this;
	}
	public String getInclude() {
		return include;
	}
	public ClientRequest include(String include) {
		this.include = include;
		return this;
	}
	public String getExclude() {
		return exclude;
	}
	public ClientRequest exclude(String exclude) {
		this.exclude = exclude;
		return this;
	}
	public String getFormat() {
		return format;
	}
	public ClientRequest format(String format) {
		this.format = format;
		return this;
	}
	public String getIdentifier() {
		return identifier;
	}
	public ClientRequest identifier(String identifier) {
		this.identifier = identifier;
		return this;
	}
	public String getPage() {
		return page;
	}
	public ClientRequest page(String page) {
		this.page = page;
		return this;
	}
	public String getAddtags() {
		return addtags;
	}
	public ClientRequest addtags(String addtags) {
		this.addtags = addtags;
		return this;
	}

	public String getEndPointName() {
		return endPointName;
	}

	public ClientRequest endPointName(String endPointName) {
		this.endPointName = endPointName;
		return this;
	}

	public String getPostCode() {
		return postCode;
	}

	public ClientRequest postCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public ClientRequest country(String country) {
		this.country = country;
		return this;
	}
	public boolean isPostCodeOnly() {
		return postCodeOnly;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public ClientRequest status(RequestStatus status) {
		this.status = status;
		return this;
	}
	public String getComment() {
		return comment;
	}
	public ClientRequest comment(String comment) {
		this.comment = comment;
		return this;
	}
	
	/**
	 * @return the clientIp
	 */
	public String getClientHost() {
		return clientHost;
	}
	/**
	 * @param clientHost the clientIp to set
	 */
	public ClientRequest clientHost(String clientHost) {
		this.clientHost = clientHost;
		return this;
	}
	/**
	 * @return the serviceIp
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the serviceIp to set
	 */
	public ClientRequest host(String host) {
		this.host = host;
		return this;
	}
	
	public boolean hasQueryParams(){
		if(Objects.nonNull(getAddtags())||
			Objects.nonNull(getExclude())||
			Objects.nonNull(getFormat())||
			Objects.nonNull(getIdentifier())||
			Objects.nonNull(getInclude())||
			Objects.nonNull(getLines())||
			Objects.nonNull(getPage())
			){
			return true;
		}else{
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientRequest [endPointName=" + endPointName + ", postCode=" + postCode + ", country=" + country
				+ ", requestId=" + requestId + ", lines=" + lines + ", include=" + include + ", exclude=" + exclude
				+ ", format=" + format + ", identifier=" + identifier + ", page=" + page + ", addtags=" + addtags
				+ ", postCodeOnly=" + postCodeOnly + ", status=" + status + ", comment=" + comment + ", derivedKey="
				+ derivedKey + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addtags == null) ? 0 : addtags.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((endPointName == null) ? 0 : endPointName.hashCode());
		result = prime * result + ((exclude == null) ? 0 : exclude.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((include == null) ? 0 : include.hashCode());
		result = prime * result + lines;
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientRequest other = (ClientRequest) obj;
		if (addtags == null) {
			if (other.addtags != null)
				return false;
		} else if (!addtags.equals(other.addtags))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (endPointName == null) {
			if (other.endPointName != null)
				return false;
		} else if (!endPointName.equals(other.endPointName))
			return false;
		if (exclude == null) {
			if (other.exclude != null)
				return false;
		} else if (!exclude.equals(other.exclude))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (include == null) {
			if (other.include != null)
				return false;
		} else if (!include.equals(other.include))
			return false;
		if (lines != other.lines)
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
}
