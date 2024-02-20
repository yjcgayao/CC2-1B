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

        int shift;
        while (true)
        {
            Console.Write("Choose an operation (1 for Encrypt, 2 for Decrypt): ");
            if (int.TryParse(Console.ReadLine(), out int choice))
            {
                if (choice == 1 || choice == 2)
                {
                    shift = (choice == 1) ? 3 : -3; // Encryption or decryption shift
                    break;
                }
                else
                {
                    Console.WriteLine("Invalid choice. Please enter 1 or 2.");
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a valid number.");
            }
        }

        string output = Encrypt(input, shift);
        Console.WriteLine($"Result: {output}");
    }
}
