import s.ExpandableStack;

public class Main {
    public static void main(String[] args)
    {
        String test1="((*))(*))$";
        stringTester(test1);
    }

    static boolean stringTester(String word)
    {
        ExpandableStack stack = new ExpandableStack();
        int minOpen = 0;
        boolean isValid = false;

        for (int i = 0; i < word.length(); i++)
        {
            char current = word.charAt(i);

            if (current == '$')
            {
                isValid = (minOpen == 0);
                break;
            }
            else if (current == '(')
            {
                stack.push(current);
                minOpen++;
            }
            else if (current == ')')
            {
                if (stack.isEmpty())
                {
                    break;
                }

                stack.pop();
                if (minOpen > 0)
                {
                    minOpen--;
                }
            }
            else if (current == '*')
            {
                stack.push(current);
                if (minOpen > 0)
                {
                    minOpen--;
                }
            }
        }

        System.out.println(word + (isValid ? " is Valid" : " is not Valid"));
        return isValid;
    }
}