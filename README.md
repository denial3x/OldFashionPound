# Old Fashion Pound

A simple java library which implements the 4 fundamental operations (addition, subtraction, multiplication and division) according to the British monetary system prior to 1970:

* 1 pound = 20 shillings.
* 1 shilling = 12 pennies.

A price in the British monetary system prior to 1970 is defined as follows:
* p = pounds
* s = shillings
* d = pence

For example, a price of **12p 6s 10d** indicates: **12 pounds, 6 shillings and 10 pence**.

The current implementation is nothing special and really easy to extend. 
In order to let the users try the application i made a runnable ".jar".

## Installation

Launch the maven command

```bash
mvn clean install
```

## Usage
* Move to `target` folder.
* Here you can find the runnable ".jar" named `oldfashionpound-x.x-SNAPSHOT.jar`.
* Launch the application with this semantics:

```bash
java -jar oldfashionpound-x.x-SNAPSHOT.jar "<expression-to-evaluate>"
```

Where the `<expression-to-evaluate>` is the expression that we want to evaluate.

The result of the expression will be printed out on the console.

### Usage Examples

**Sum**
```bash
java -jar oldfashionpound-x.x-SNAPSHOT.jar "5p 2s 2d + 2p 4s 2d"
```
_Output:_
`7p 6s 4d`
---
**Subtraction**
```bash
java -jar oldfashionpound-x.x-SNAPSHOT.jar "5p 2s 2d - 2p 4s 2d"
```
_Output:_
`2p 18s`
---
**Multiplication**
```bash 
java -jar oldfashionpound-x.x-SNAPSHOT.jar "5p 2s 2d * 2"
```
_Output:_
`10p 4s 4d`
---
**Division**
```bash 
java -jar oldfashionpound-x.x-SNAPSHOT.jar "5p 2s 2d / 3"
```
_Output:_
`1p 14s ( 2d )`
---
## Contributing
Pull requests are welcome. For major changes or any ideas please open an issue first to discuss what you would like to change or implement.

## License
[MIT](https://choosealicense.com/licenses/mit/)
