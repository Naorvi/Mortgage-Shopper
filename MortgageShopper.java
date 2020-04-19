class MortgageShopper {

        public static void main(String[] args) throws Exception {
                GUI g=new GUI();
                Controller c=new Controller(g);
                c.initialGUI();
                //BankSQL.readBanksSQL();
                //System.out.println(BankSQL.getList().toString());
        }
}
