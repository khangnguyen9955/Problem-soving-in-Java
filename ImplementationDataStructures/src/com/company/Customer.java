package com.company;

public class Customer {
    public static class CustomerAccount{

        boolean subscription = false;
        private String name;
        private String DOB;
        private String phone;
        private String email;
        private double balance;
    }
    
    public static void main(String[] args) {

       CustomerAccount customer = new CustomerAccount();
        boolean Islogged = false;
        int subscriptionPrice = 100;
          if(Islogged == true){
            if(customer.subscription == true){
                return;
            }
            else{
                boolean requestConfirm = false;
                if(requestConfirm == true){
                    if(customer.balance >= subscriptionPrice){
                        customer.subscription = true;
                        customer.balance -= subscriptionPrice;
                    }
                    else{

                        return;
                    }
                }
                else{
                   return;
                }

            }



       }





    }


}
