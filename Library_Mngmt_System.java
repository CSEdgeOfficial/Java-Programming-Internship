//Task-6 Medium Level
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 
//Book class
class Book{
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
//Member class
class Member{
    private String name;
    private int memberId;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
    }

    public String getName(){
        return name;
    }

    public int getMemberId(){
        return memberId;
    }
}
//Borrow class
class Borrowing{
    private int memberId;
    private String bookN;
    private Date borrowDate;

    public Borrowing(int memberId, String bookN, Date borrowDate){
        this.memberId = memberId;
        this.bookN = bookN;
        this.borrowDate = borrowDate;
    }

    public int getMemberId(){
        return memberId;
    }

    public String getTitle(){
        return bookN;
    }

    public Date getBorrowDate(){
        return borrowDate;
    }
}
//library class includes Managing books and members,borrowing/returning books,borrowing history,overdue notifications
class Library{
    private List<Book> books;
    private List<Member> members;
    private List<Borrowing> borrowings;
    private Map<Member, List<Borrowing>> borrowingHistory;

    public Library(){
        books = new ArrayList<>();
        members = new ArrayList<>();
        borrowings = new ArrayList<>();
        borrowingHistory = new HashMap<>();
    }

    public void addBook(){
        Scanner cs=new Scanner(System.in);
        System.out.print("Enter Book title name to add : ");
        String title=cs.nextLine();
        System.out.print("Enter Book Author name to add : ");
        String author=cs.nextLine(); 
        books.add(new Book(title, author));
        System.out.println("Book '" + title + "' by " + author + " added to the library.");
    }

    public void addMember(String name,int memberId){
        members.add(new Member(name, memberId));
        System.out.println("Member '" + name + "' with ID " + memberId + " added to the library.");
    }

    public void borrowBook(){
        Scanner cs=new Scanner(System.in);
        System.out.print("Enter memberId to borrow book : ");
        int memberId=cs.nextInt();
        System.out.print("Enter book title to borrow book : ");
        cs.nextLine();
        String bookTitle=cs.nextLine();
        System.out.print("Enter borrow Date (dd/mm/yyyy): ");
        
        String dateStr = cs.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null; 
        try{  
            date = sdf.parse(dateStr);  
            System.out.println("Input date: " + sdf.format(date));  
        }
        catch(ParseException e){  
            System.out.println("Invalid date format");  
        }  
        Member member = findMember(memberId);
        List<Borrowing> history = borrowingHistory.getOrDefault(member, new ArrayList<>());
        history.add(new Borrowing(memberId, bookTitle, date));
        borrowingHistory.put(member, history);
    
        borrowings.add(new Borrowing(memberId,bookTitle,date));
        if(member != null){
            Book book = findAvailableBook(bookTitle);
            if (book != null){
                book.setAvailable(false);
                System.out.println("Book '" + bookTitle + "' borrowed by " + member.getName() + ".");
            }
            else{
                System.out.println("Book '" + bookTitle + "' is not available.");
            }
        } 
        else{
            System.out.println("Invalid member ID.");
        }
    }

    public void returnBook() {
        Scanner cs=new Scanner(System.in);
        System.out.print("Enter memberId to return book : ");
        int memberId=cs.nextInt();
        System.out.print("Enter book title to return book : ");
        cs.nextLine();
        String bookTitle=cs.nextLine();
        Member member = findMember(memberId);
        if (member != null) {
            Book book = findBorrowedBook(member, bookTitle);
            if (book != null) {
                book.setAvailable(true);
                System.out.println("Book '" + bookTitle + "' returned by " + member.getName() + ".");
            } else {
                System.out.println("You haven't borrowed '" + bookTitle + "'.");
            }
        } else {
            System.out.println("Invalid member ID.");
        }
    }

    private Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    private Book findAvailableBook(String bookTitle) {
         for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    private Book findBorrowedBook(Member member, String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && !book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
    public void BorrowingHistory(int memberId) {
        Member member = findMember(memberId);
        if (member != null){
            List<Borrowing> history = borrowingHistory.getOrDefault(member, new ArrayList<>());
            if (history.isEmpty()){
                System.out.println("No borrowing history for member " + member.getName() + ".");
            }
            else{
                System.out.println("Borrowing History for " + member.getName() + ":");
                for (Borrowing borrowing : history) {
                    System.out.println("Book: " + borrowing.getTitle()+",Borrowed by: "+borrowing.getMemberId() +
                            ", Borrowed on: " + borrowing.getBorrowDate());
                }
            }
        }
        else{
            System.out.println("Invalid member ID.");
        }
    }
    public void checkOverdueBooks(){
        Date currentDate = new Date(); 
        for (Borrowing borrowing : borrowings){
            Date dueDate = borrowing.getBorrowDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dueDate);
            cal.add(Calendar.DATE, 14); 
            dueDate = cal.getTime();
            if (currentDate.after(dueDate)){
               Member member = findMember(borrowing.getMemberId());
                if (member != null){
                    System.out.println("Dear " + member.getName() + ", you have overdue books.");
                    System.out.println("Please return the following books:");
                    System.out.println("- " + borrowing.getTitle() + ", Borrowed on: " + borrowing.getBorrowDate());
                    System.out.println();
                }
            }
        }
    }
}

public class Library_Mngmt_System{
    public static void main(String[] args){
        Scanner cs=new Scanner(System.in);
        Library library = new Library();
        
        
        System.out.println("Welcome to Libraryhub \n");
        System.out.print("Enter your name : ");
        String cus_name=cs.nextLine();
        System.out.print("Enter your Member id : ");
        int cus_id=cs.nextInt();
        library.addMember(cus_name,cus_id); 
        
        System.out.println("Please select any Library Management options :\n");
        boolean finish=false;
        
        while(!finish){
            System.out.println("\n1.Adding New Book \n2.Adding New Member \n3.Borrowing Book \n4.Returning book \n5.Borrowing History \n6.OverDue Notifications\n");
            int option=cs.nextInt();
            switch(option){
                case 1:
                    library.addBook();
                    break;
                case 2:
                System.out.print("Enter Member Name : ");
                    String name=cs.next();
                    System.out.print("Enter Member id : ");
                    int memberId=cs.nextInt();
                    library.addMember(name,memberId);
                    break;
                case 3:
                    library.borrowBook();
                    break;
                case 4:
                    library.returnBook();
                    break;
                case 5:
                    System.out.print("Enter Id to browse borrow History : \n");
                    int member_id=cs.nextInt();
                    library.BorrowingHistory(member_id);
                    break;
                case 6:
                    library.checkOverdueBooks();
                    break;    
                default:
                    finish=true;
            }
            
        }
    
       
    }
}
