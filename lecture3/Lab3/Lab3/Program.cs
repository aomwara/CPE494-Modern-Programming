using System;

namespace Lab3
{
    class MainClass
    {
        public static void Main(string[] args)
        { 
            // Input RectangularFrom
            ComplexNumber complexNumber1 = ComplexNumber.CreateRectangularFrom(5, 9);
            Console.WriteLine("ComplexNumber 1:" + complexNumber1.PrintRectangularFrom());

            // Input PolarFrom
            ComplexNumber complexNumber2 = ComplexNumber.CreatePolarFrom(10, 30);
            Console.WriteLine("ComplexNumber 2:" + complexNumber2.PrintRectangularFrom() + "(convert form PolarFrom)\n");

            // Add RectangularFrom and PolarFrom
            Console.WriteLine("Add: RectangularFrom & PolarFrom");
            ComplexNumber complexNumber3 = complexNumber1.Add(complexNumber2);
            Console.WriteLine(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                    + complexNumber3.PrintPolarFrom() + "\n");

            // Subtract RectangularFrom and PolarFrom
            Console.WriteLine("Subtract: RectangularFrom & PolarFrom");
            complexNumber3 = complexNumber1.Subtract(complexNumber2);
            Console.WriteLine(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                    + complexNumber3.PrintPolarFrom() + "\n");

            // Multiply RectangularFrom and PolarFrom
            Console.WriteLine("Multiply: RectangularFrom & PolarFrom");
            complexNumber3 = complexNumber1.Multiply(complexNumber2);
            Console.WriteLine(" | Result: " + complexNumber3.PrintRectangularFrom() + "\n | = "
                    + complexNumber3.PrintPolarFrom() + "\n");
            Console.WriteLine("_______End_______");
        }
    }
}
