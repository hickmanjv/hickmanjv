/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public class VipUser extends RegisteredUser implements VipUserAction {
    
    private Integer vipLevel;
    public final double vipDiscount;
    
    public VipUser(String username, String password, int vipLevel) {
        super(genUserId(), UserType.VIP, username, password); 
        this.vipDiscount = 0.4; 
        this.vipLevel = vipLevel; 
    }
    
    public VipUser(String userId, UserType userType, String username, String password, int vipLevel) {
        super(userId, userType, username, password);
        this.vipDiscount = 0.5;
        this.vipLevel = vipLevel;
    }

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }
    
    @Override
    public void bookPurchase(double bookPrice) {
        System.out.println("Book Price: " + bookPrice * vipDiscount);
    }

    @Override
    public void foodPurchase(double foodPrice) {
        System.out.println("Food Price " + foodPrice * vipDiscount);
    }

    @Override
    public void customService() {
        System.out.println("Free Custom Service");
    }
    
    @Override
    public String getUserInfo(){
        return String.format("User ID: %s, Username: %s, Password: %s , Vip Level: %d, User Type: " + userType, userId, username, password,vipLevel);
    }  
}