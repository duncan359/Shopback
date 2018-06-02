package com.shopback.di;


import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;


@JsonObject
public class UserListResponse{


	@JsonField(name ="gists_url")
	private String gistsUrl;


	@JsonField(name ="repos_url")
	private String reposUrl;


	@JsonField(name ="following_url")
	private String followingUrl;


	@JsonField(name ="starred_url")
	private String starredUrl;


	@JsonField(name ="login")
	private String login;


	@JsonField(name ="followers_url")
	private String followersUrl;


	@JsonField(name ="type")
	private String type;


	@JsonField(name ="url")
	private String url;


	@JsonField(name ="subscriptions_url")
	private String subscriptionsUrl;


	@JsonField(name ="received_events_url")
	private String receivedEventsUrl;


	@JsonField(name ="avatar_url")
	private String avatarUrl;


	@JsonField(name ="events_url")
	private String eventsUrl;


	@JsonField(name ="html_url")
	private String htmlUrl;


	@JsonField(name ="site_admin")
	private boolean siteAdmin;

	@JsonField(name ="id")
	private int id;


	@JsonField(name ="gravatar_id")
	private String gravatarId;


	@JsonField(name ="node_id")
	private String nodeId;


	@JsonField(name ="organizations_url")
	private String organizationsUrl;

	public void setGistsUrl(String gistsUrl){
		this.gistsUrl = gistsUrl;
	}

	public String getGistsUrl(){
		return gistsUrl;
	}

	public void setReposUrl(String reposUrl){
		this.reposUrl = reposUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}

	public void setFollowingUrl(String followingUrl){
		this.followingUrl = followingUrl;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public void setStarredUrl(String starredUrl){
		this.starredUrl = starredUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setFollowersUrl(String followersUrl){
		this.followersUrl = followersUrl;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setSubscriptionsUrl(String subscriptionsUrl){
		this.subscriptionsUrl = subscriptionsUrl;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public void setReceivedEventsUrl(String receivedEventsUrl){
		this.receivedEventsUrl = receivedEventsUrl;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setEventsUrl(String eventsUrl){
		this.eventsUrl = eventsUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setSiteAdmin(boolean siteAdmin){
		this.siteAdmin = siteAdmin;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	public void setOrganizationsUrl(String organizationsUrl){
		this.organizationsUrl = organizationsUrl;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}
}