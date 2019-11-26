public class BankAccount{
	
	private int acc_no;
	private double balance;
	private String firstName, lastName;
	private int num_transactions;
	static final int MAX_TRANSACTIONS_DAY = 5;
	static final double MIN_BALANCE = 1000.0;
	
	public BankAccount(int acc_no,
                   java.lang.String email,
                   double balance){

		this.num_transactions = 0;
		this.acc_no = acc_no;
		this.balance = MIN_BALANCE + balance;

		StringTokenizer string1 = new StringTokenizer(email, ".");

		this.firstName = string1.nextToken();
		StringTokenizer string2 = new StringTokenizer(string1.nextToken(), "@");
		this.lastName = string2.nextToken();

	}

	public BankAccount(int acc_no, java.lang.String email){
		this(acc_no, email, MIN_BALANCE);
	}

	public BankAccount(int acc_no, double balance){
		this(acc_no, "John.Doe@", MIN_BALANCE + balance);
	}

	public BankAccount(int acc_no){
		this(acc_no, "John.Doe@", MIN_BALANCE);
	}

	public int getAccountNumber(){
		return acc_no;
	}

	public java.lang.String getName(){
		return this.firstName + " " + this.lastName;
	}

	public double getBalance(){
		return balance;
	}

	public int deposit(double amount){

		if(amount <= 0){
			return 0;
		}else{

			if (num_transactions >= MAX_TRANSACTIONS_DAY) {
				
				this.balance += amount * 0.95;
			}else{
				this.balance += amount;
			}
			num_transactions++;
			return 1;
		}

		return 0;
	}

	public int withdraw(double amount){
		if (amount <= 0) {
			return -1;
		}else{

			if (this.balance - amount < MIN_BALANCE) {
				return 0;
			}else{
				if (num_transactions >= MAX_TRANSACTIONS_DAY) {
					
					if (this.balance - amount * 1.05 < MIN_BALANCE) {
						return 0;
					}else{
						this.balance -= amount * 1.05;
						num_transactions++;
						return 1;
					}
				}else{
					this.balance -= amount;
					num_transactions++;
					return 1;
				}
			}
		}
		return 0;

	}

	public void printDetails(){
		System.out.println("Acc No : " + acc_no);
		System.out.println("Name : " + firstName + " " + lastName);
		System.out.println("Balance : " + balance);
	}
}