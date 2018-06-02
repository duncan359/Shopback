package com.shopback.data;


import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class UserDetail{

	@JsonField(name ="gists_url")
	private String gistsUrl;


	@JsonField(name ="repos_url")
	private String reposUrl;


	@JsonField(name ="following_url")
	private String followingUrl;


	@JsonField(name ="bio")
	private String bio;


	@JsonField(name ="created_at")
	private String createdAt;


	@JsonField(name ="login")
	private String login;


	@JsonField(name ="type")
	private String type;


	@JsonField(name ="blog")
	private String blog;


	@JsonField(name ="subscriptions_url")
	private String subscriptionsUrl;


	@JsonField(name ="updated_at")
	private String updatedAt;


	@JsonField(name ="site_admin")
	private boolean siteAdmin;


	@JsonField(name ="company")
	private Object company;


	@JsonField(name ="id")
	private int id;


	@JsonField(name ="public_repos")
	private int publicRepos;


	@JsonField(name ="gravatar_id")
	private String gravatarId;


	@JsonField(name ="email")
	private Object email;


	@JsonField(name ="organizations_url")
	private String organizationsUrl;


	@JsonField(name ="hireable")
	private Object hireable;


	@JsonField(name ="starred_url")
	private String starredUrl;


	@JsonField(name ="followers_url")
	private String followersUrl;


	@JsonField(name ="public_gists")
	private int publicGists;


	@JsonField(name ="url")
	private String url;


	@JsonField(name ="received_events_url")
	private String receivedEventsUrl;


	@JsonField(name ="followers")
	private int followers;


	@JsonField(name ="avatar_url")
	private String avatarUrl;


	@JsonField(name ="events_url")
	private String eventsUrl;


	@JsonField(name ="html_url")
	private String htmlUrl;


	@JsonField(name ="following")
	private int following;


	@JsonField(name ="name")
	private String name;


	@JsonField(name ="location")
	private String location;


	@JsonField(name ="node_id")
	private String nodeId;

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

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setBlog(String blog){
		this.blog = blog;
	}

	public String getBlog(){
		return blog;
	}

	public void setSubscriptionsUrl(String subscriptionsUrl){
		this.subscriptionsUrl = subscriptionsUrl;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSiteAdmin(boolean siteAdmin){
		this.siteAdmin = siteAdmin;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public void setCompany(Object company){
		this.company = company;
	}

	public Object getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPublicRepos(int publicRepos){
		this.publicRepos = publicRepos;
	}

	public int getPublicRepos(){
		return publicRepos;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public void setEmail(Object email){
		this.email = email;
	}

	public Object getEmail(){
		return email;
	}

	public void setOrganizationsUrl(String organizationsUrl){
		this.organizationsUrl = organizationsUrl;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}

	public void setHireable(Object hireable){
		this.hireable = hireable;
	}

	public Object getHireable(){
		return hireable;
	}

	public void setStarredUrl(String starredUrl){
		this.starredUrl = starredUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public void setFollowersUrl(String followersUrl){
		this.followersUrl = followersUrl;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public void setPublicGists(int publicGists){
		this.publicGists = publicGists;
	}

	public int getPublicGists(){
		return publicGists;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setReceivedEventsUrl(String receivedEventsUrl){
		this.receivedEventsUrl = receivedEventsUrl;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public void setFollowers(int followers){
		this.followers = followers;
	}

	public int getFollowers(){
		return followers;
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

	public void setFollowing(int following){
		this.following = following;
	}

	public int getFollowing(){
		return following;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}
}