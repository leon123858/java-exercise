# hw

- A List data structure is implemented with a String array which can contain a series of String objects.
- We can access List by calling the get() method with an index and know how many Strings inside the List with a public
  attribute: length.
- Furthermore, another data structure called SkipList which consists of a series of SkipNodes.
- Each SkipNode can be accessed by invoking the getNode() method in SkipList with an index. And we have the idea about
  the size of SkipList with its size() method.
- Now we have to traverse both List and SkipList to print out those object items in the two different data structures
  for some purpose.

## SPEC

```agsl
int size();
int length();
void add(String content);
String get(int index);
String getNode(int index);
void print();
```

```
Input:
    Create [DataStructure_name] [DataStructure]
    Add [DataStructure_name] [Content]
    Length [DataStructure_name]
    Size [DataStructure_name]
    Get [DataStructure_name] [index]
    GetNode [DataStructure_name] [index]
    PrintOutList [DataStructure_name]
…
Output:
    //if [DataStructure] is List
        //input: Length [DataStructure_name]: print how many Strings
        [String_num]
        //input: Size [DataStructure_name]
        List do not have method size
        // input: Get [DataStructure_name] [index]: print content at [index]
        [Content_index]
        // input: GetNode [DataStructure_name] [index]
        List do not have method getNode
        //input: PrintOutList [DataStructure_name], print all contents
        [Content_0]
        [Content_1]
…


    //if [DataStructure] is SkipList
        //input: Length [DataStructure_name]
        SkipList can not access length
        //input: Size [DataStructure_name]: print how many SkipNode
        [SkipNode_num]
        // input: Get [DataStructure_name] [index]
        SkipList do not have method get
        // input: GetNode [DataStructure_name] [index] : print content at [index]
        SkipNode:[Content_index]
        //input: PrintOutList [DataStructure_name], print all contents
        SkipNode:[Content_0]
        SkipNode:[Content_1]
…
Comment:
    [DataStructure] must be one of followings:
        List
        SkipList
```