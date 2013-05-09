RestModelGenerator
==================

You can use this tool to define a rest model and generate source code for various languages.

A simple syntax is used to define your objects used in your json. Once you have created these objects you can generate you code as required.

Currently supported languages are:

+ Java

Feel free to get started! Replace the model files in the `models` directory with some of your own then run `org.remotetech.modelGenerator.Generator`. 

Creating model files
--------------------

File names must be in the following format `"<class name>.model"`. Example: `myClass.model`

All line endings are denoted by a semicolumn and all white spaces in files are ignored.

The first entry in the file should be the output directory or package for the file, folders delimeted by forward slash. 

Example:
```
test/output/dir;
```

After the folder output line the class body declration can begin. The class body is encapsulated by curly brackets. You declear each variable and variable type of the class within the body. Varaible names must be in lower camel case.

Variable name off member variables are declared first, followed by a column then the type and then a semicolumn to denote the end of line `"<variable name>:<type>;"`.

Example:
```
testVar:String;
```

A List is declared the same as normal variables (as if the list was the type) but the type of objects in the list is denoted following the type. `"<variable name>:List:<type>;"`

Example:
```
testList:List:String;
```

The following types are currently supported:
```
varString:String;
varNumber:Integer;
varFloatingPoint:Float;
varListOfStrings:List:String;
varOwnObject:CoustomModelObject;
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

Replacing Templates
--------------------
If you look at the source code in `CodeGeneration/src/main/resources` you will find the templates. You can copy these files change them as you see fit then place them in the directory you are running the project.

Feature Development
---------------------
There are allot more features to some to RestModelGenerator so if there is something think needs adding or want to help out let me know beachy.greg@gmail.com!

Features being developed
+ C# language generation.
+ Create a better way to overide templates.
+ Add support for Map type.
