class Solution {

    /*
    Implementation Notes:
    Encoding / Decoding A String

    Set includes 256 ASCII chars
    O(m) time, O(m + n) space for encode() / decode()
    
    Naive:
    You could just use a delimeter. "Hi [delim] Hello"

    Huffman encoding?  
    They dont mention compression, and Huffman encoding requires passing the tree and the string, breaking our function requirements.

    Implementation Idea #1
    For a generalizable algorith,, a delimeter won't work because it may be in the character set.

    We could record the lengths of the string and the strings at the end, but that would still require a comma.

    2,2,2,,hello

    This delimeter here "," serves as only a delimeter for the numbered length of the string, its an edge case.
    It should work if we parse through it, it will use the comma correctly if we expect this pattern always. 

    But we don't have a delimter to read the numbers... how will we know what to stop, we wont. so in the same theme, we establish a pattern in our safe zone (before any characters).

    2,2,2,#,hello 

    now that , in the 7th index place is safe.

    */

    public String encode(List<String> strs) 
    {
        // 0 length Case
        if (strs.size() == 0 )
        {
            return new String("");
        }

        // 1 - N length Case

        // Building Count String
        char delim = ',';
        char final_delim = '#';
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < strs.size(); i++)
        {
            String temp_str = strs.get(i);
            sb.append(temp_str.length());
            sb.append(delim);
        }
        sb.append(final_delim);

        // Building Rest of string
        for (int i = 0 ; i < strs.size(); i++)
        {
            String temp_str = strs.get(i);
            sb.append(temp_str);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) 
    {
        List<String> decoded_strings = new ArrayList<>();
        char delim = ',';
        char final_delim = '#';

        // Decode Count String
        
        // Find our final_delim, then BREAK
        int final_delim_index = -1;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == final_delim)
            {
                final_delim_index = i;
                break;
            }
        }

        // If we could never find the delim, its an empty string.
        if ( final_delim_index == -1 )
        {
            return decoded_strings;
        }
        

        // Cut Strings based on final_delim
        String unprocessed_left_string = str.substring(0, final_delim_index);

        String unprocessed_right_string = str.substring(final_delim_index + 1, str.length());

        System.out.println(unprocessed_left_string);
        System.out.println(unprocessed_right_string);

        // Get lengths
        String[] lengths_as_strings = unprocessed_left_string.split(String.valueOf(delim));

        int[] lengths = new int[lengths_as_strings.length];
        for (int i = 0; i < lengths_as_strings.length; i++)
        {
            System.out.println(lengths[i]);
            lengths[i] = Integer.parseInt(lengths_as_strings[i]);
        }
        
        StringBuilder right_string_builder = new StringBuilder(unprocessed_right_string);

        for (int length : lengths)
        {
            String curr_string = right_string_builder.substring(0,length);
            right_string_builder.delete(0, length);
            decoded_strings.add(curr_string);
        }

        for (String temp_str : decoded_strings )
        {
            System.out.println(temp_str);
        }


        return decoded_strings;

    }
}
