package main.src;

public class Number {

    private String RechargeCode ;
    private String ConsultCode ;






    public Number(String number , String recharge) {
        if (number.length()>0 && recharge.length()>0){
            switch (number.charAt(0)) {
                case '9':
                    this.RechargeCode = "*123*"+recharge+"#";
                    this.ConsultCode = "*122#";
                    break;
                case '2':
                    this.RechargeCode = "*101*"+recharge+"#";
                    this.ConsultCode = "*100#";
                    break;

                case '5':
                    this.RechargeCode = "*100*"+recharge+"#";
                    this.ConsultCode = "*101#";
                    break;

                default:
                    this.RechargeCode = "";
                    this.ConsultCode = "";
                    break;
            }
        } else if (number.length()>0) {
            switch (number.charAt(0)) {
                case '9':
                    this.RechargeCode = "*123* #";
                    this.ConsultCode = "*122#";
                    break;
                case '2':
                    this.RechargeCode = "*101* #";
                    this.ConsultCode = "*100#";
                    break;

                case '5':
                    this.RechargeCode = "*100* #";
                    this.ConsultCode = "*101#";
                    break;

                default:
                    this.RechargeCode = "";
                    this.ConsultCode = "";
                    break;
            }
        }else {
            this.RechargeCode = recharge;
            this.ConsultCode = "";
        }
    }

    public String getRechargeCode() {
        return RechargeCode;
    }

    public void setRechargeCode(String rechargeCode) {
        RechargeCode = rechargeCode;
    }

    public String getConsultCode() {
        return ConsultCode;
    }

    public void setConsultCode(String consultCode) {
        ConsultCode = consultCode;
    }
}
