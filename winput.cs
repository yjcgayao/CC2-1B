using System;

class Program
{
    static string Encrypt(string text, int shift)
    {
        char[] result = new char[text.Length];
        for (int i = 0; i < text.Length; i++)
        {
            char ch = text[i];
            if (char.IsLetter(ch))
            {
                char baseChar = char.IsUpper(ch) ? 'A' : 'a';
                result[i] = (char)((ch - baseChar + shift) % 26 + baseChar);
            }
            else
            {
                result[i] = ch;
            }
        }
        return new string(result);
    }
    static void Main()
    {
        Console.Write("Enter a message: ");
        string input = Console.ReadLine();

        Console.Write("Choose an operation (1 for Encrypt, 2 for Decrypt): ");
        int choice = int.Parse(Console.ReadLine());

        Console.Write("Enter the number of shifts: ");
        int shift = int.Parse(Console.ReadLine()); // User-defined shift value

        string output = (choice == 1) ? Encrypt(input, shift) : Encrypt(input, 26 - shift);

        Console.WriteLine($"Result: {output}");
    }
}
