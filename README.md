RestModelGenerator
==================

You can use this tool to define a rest model and generate source code for various languages.

A simple syntax is used to define your objects used in your json. Once you have created these objects you can generate you code as required.

Currently supported languages are:

+ Java



Creating model files
--------------------

You need to name the file in the following format `"<class name>.model"`. Example: `myClass.model`

All line endings are denoted by a semicolumn and all white spaces in files are ignored.

The first entry in the file should be the output directory or package for the file, folders delimeted by forward slash. 

Example:
```html
test/output/dir;
```

After the this line the class body declration can begin. The class body is encapsulated by curly brackets. You declear each variable and variable type of the class within the body. Varaible names must be in lower camel case.

Variable name off member variables are declared first, followed by a column then the type and then a semicolumn to denote the end of line `"<variable name>:<type>;"`.

Example:
```html
testVar:String;
```

A List is declared the same as normal variables (as if the list was the type) but the type of objects in the list is denoted following the type. `"<variable name>:List:<type>;"`

Example:
```html
testList:List:String;
```

Model file example
----------------------
Filename: `test.model`
```html
com/model/test;
{
    id:Integer;
    name:String;

}
```

This would generate the following in java:
```java
package com/model/test;

public class Test {
   private Integer id;
   private String name;
   
   public Integer getId(){
      return this.id;
   }
   
   public void setId(String id){
      this.id = id;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      this.name = name;
   }
}
```
