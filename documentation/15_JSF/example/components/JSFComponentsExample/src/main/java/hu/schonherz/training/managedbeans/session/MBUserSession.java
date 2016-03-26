package hu.schonherz.training.managedbeans.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hu.schonherz.training.records.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "userSession")
@SessionScoped
public class MBUserSession implements Serializable {

	private static final long serialVersionUID = -6387831835982539143L;
	private String userName; // InputText
	private String address; // InputTextarea
	private String password; // InputSecret
	private int age; // Messages Example
	private String hiddenInfo = "Hidden Information"; // InputHidden
	private Boolean newsLetter; // SelectBooleanCheckbox
	private String[] propertiesHardCoded; // SelectManyCheckbox
	private String[] selectedUsers; // SelectManyCheckbox
	private String[] propertiesWithMap; // SelectManyCheckbox

	private String selectedUserByRadio; // SelectOneRadio
	private String selectedUserByListbox; // SelectOneListbox
	private String selectedUserByOnemenu;// SelectOnemenu

	private List<User> userArray;
	private Map<String, Object> propertiesMap; // Label,Value
	private String[] selectedUsersByManyListbox; // SelectManyListbox
	private String[] selectedUsersByManymenu; // SelectManymenu

	private String outputTextString = "<b><i>Jani</i></b>";
	private String outputFormatText = "Hello {0}";
	private String outputFormatHtml = "<input type=\"{0}\" {1} value=\"{2}\" />";
	
	//For Converters
	private double amount;
	private Date currentDate = new Date();
	// For Validators
	private String email;

	@PostConstruct
	public void init() {
		userArray = new ArrayList<User>();
		userArray.add(new User(1, "Jani", "Füredi út"));
		userArray.add(new User(2, "Judit", "Csapó utca"));
		userArray.add(new User(3, "Szilárd", "Mikerpércsi út"));
		userArray.add(new User(4, "Bözsi", "Miklós utca"));
		userArray.add(new User(5, "Pityu", "Böszörményi út"));
		propertiesMap = new LinkedHashMap<String, Object>();
		propertiesMap.put("Jani", 1); // label,value
		propertiesMap.put("Judit", 2);
		propertiesMap.put("Szilárd", 3);
		propertiesMap.put("Bözsi", 4);
		propertiesMap.put("Pityu", 5);
	}

	public void doAction() {
		System.out.println("doAction called.");
		System.out.println("do Something.");
	}

	public String goLoginPage() {
		return "login";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHiddenInfo() {
		return hiddenInfo;
	}

	public void setHiddenInfo(String hiddenInfo) {
		this.hiddenInfo = hiddenInfo;
	}

	public Boolean getNewsLetter() {
		return newsLetter;
	}

	public void setNewsLetter(Boolean newsLetter) {
		this.newsLetter = newsLetter;
	}

	public String[] getPropertiesHardCoded() {
		return propertiesHardCoded;
	}

	public void setPropertiesHardCoded(String[] propertiesHardCoded) {
		this.propertiesHardCoded = propertiesHardCoded;
	}

	public String[] getPropertiesWithMap() {
		return propertiesWithMap;
	}

	public void setPropertiesWithMap(String[] propertiesWithMap) {
		this.propertiesWithMap = propertiesWithMap;
	}

	public List<User> getUserArray() {
		return userArray;
	}

	public void setUserArray(List<User> userArray) {
		this.userArray = userArray;
	}

	public String[] getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(String[] selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public Map<String, Object> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(Map<String, Object> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	public String getSelectedUserByRadio() {
		return selectedUserByRadio;
	}

	public void setSelectedUserByRadio(String selectedUserByRadio) {
		this.selectedUserByRadio = selectedUserByRadio;
	}

	public String getSelectedUserByListbox() {
		return selectedUserByListbox;
	}

	public void setSelectedUserByListbox(String selectedUserByListbox) {
		this.selectedUserByListbox = selectedUserByListbox;
	}

	public String[] getSelectedUsersByManyListbox() {
		return selectedUsersByManyListbox;
	}

	public void setSelectedUsersByManyListbox(String[] selectedUsersByManyListbox) {
		this.selectedUsersByManyListbox = selectedUsersByManyListbox;
	}

	public String getSelectedUserByOnemenu() {
		return selectedUserByOnemenu;
	}

	public void setSelectedUserByOnemenu(String selectedUserByOnemenu) {
		this.selectedUserByOnemenu = selectedUserByOnemenu;
	}

	public String[] getSelectedUsersByManymenu() {
		return selectedUsersByManymenu;
	}

	public void setSelectedUsersByManymenu(String[] selectedUsersByManymenu) {
		this.selectedUsersByManymenu = selectedUsersByManymenu;
	}

	public String getOutputTextString() {
		return outputTextString;
	}

	public void setOutputTextString(String outputTextString) {
		this.outputTextString = outputTextString;
	}

	public String getOutputFormatText() {
		return outputFormatText;
	}

	public void setOutputFormatText(String outputFormatText) {
		this.outputFormatText = outputFormatText;
	}

	public String getOutputFormatHtml() {
		return outputFormatHtml;
	}

	public void setOutputFormatHtml(String outputFormatHtml) {
		this.outputFormatHtml = outputFormatHtml;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}