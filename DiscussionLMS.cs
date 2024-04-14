namespace DiscussionLMS
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Library cc31bLibrary = new Library();
            
            Book greatGatsby = new Book("Great Gatsby", "Author");
            Book got = new Book("Song of Ice and Fire", "GRR Martin");
            Book harryPotter = new Book("Philosopher's Stone", "JK Rowling");
            Book wow = new Book("Warcraft", "Blizzard");

            cc31bLibrary.AddBook(greatGatsby);
            cc31bLibrary.AddBook(got);
            cc31bLibrary.AddBook(harryPotter);
            cc31bLibrary.AddBook(wow);

            LibraryMember hannah = new LibraryMember("Hannah");

            cc31bLibrary.LendBook(got, hannah);

            cc31bLibrary.DisplayBorrowedBooksByMember(hannah);

            cc31bLibrary.DisplayAvailableBooks();
        }
    }
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public bool IsAvailable { get; set; }
        public DateTime timeBorrowed { get; set; }

        public Book(string title, string author)
        {
            Title = title;
            Author = author;
            IsAvailable = true;
        }
    }

    class LibraryMember
    {
        private static int s_IDSeed = 123;
        public string Name { get; set; }
        int ID
        {
            get
            {
                return s_IDSeed++;
            }
        }
        public List<Book> BorrowedBooks { get; set; }

        public LibraryMember(string name)
        {
            Name = name;
            BorrowedBooks = new List<Book>();
        }
    }

    class Library
    {
        List<Book> Books { get; set; }
        List<LibraryMember> Members { get; set; }

        public Library()
        {
            Books = new List<Book>();
            Members = new List<LibraryMember>();
        }
        public Library(List<Book> listBook)
        {
            Books = listBook;
        }
        public void AddBook(Book book)
        {
            Books.Add(book);
        }
        public void RemoveBook(Book book)
        {
            Books.Remove(book);
        }
        public void LendBook(Book book, LibraryMember libraryMember)
        {
            if (book.IsAvailable)
            {
                book.IsAvailable = false;
                book.timeBorrowed = DateTime.Now;
                libraryMember.BorrowedBooks.Add(book);
            }
            else
            {
                Console.WriteLine("Books is not available.");
            }
        }
        public List<Book> GetAllAvailableBooks()
        {
            List<Book> availableBooks = new List<Book>();
            foreach (Book book in Books)
            {
                if(book.IsAvailable)
                {
                    availableBooks.Add(book);
                }
            }
            return availableBooks;        
        }

        public void DisplayAvailableBooks()
        {
            Console.WriteLine("All available books in library:");
            List<Book> availableBooks = GetAllAvailableBooks();
            foreach (Book book in availableBooks)
            {
                Console.WriteLine($"\t{book.Title} by {book.Author}");
            }
        }

        public void DisplayBorrowedBooksByMember(LibraryMember member)
        {
            Console.WriteLine($"Borrowed books by {member.Name}");
            foreach (Book book in member.BorrowedBooks)
            {
                Console.WriteLine($"\t{book.Title} by {book.Author}");
            }
        }
    }
}
