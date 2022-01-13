
class StaticArray {

    theArray: Array<number>;
    nElements: number;

    constructor(size:number) {
        this.theArray = new Array(size);
        this.nElements = 0;
        console.log(this.theArray)
    }

    print = () => {
        console.log("[")
        for (let i = 0; i < this.theArray.length; i++) {
            if (i < this.nElements-1) {
                console.log(this.theArray[i] + ", ")
            } else {
                console.log(this.theArray[i] + "]")
            }
            
        }
    }

    insert = (e:number) => {
        if (this.theArray.length == this.nElements) {
            let doubledArray:number[] = new Array(this.nElements * 2);
            this.theArray.forEach((el, i) => {
                doubledArray[i] = el;
            })
            this.theArray = doubledArray;
        }

        this.theArray[this.nElements] = e;
        this.nElements++;
        console.log(`Added ${e} to array.`);
    }

    removeAt = (index:number) => {
        if ( (index < 0) || (index >= this.nElements)) {
            throw new RangeError("Index out of range");
        } else {
            let removeValue:number = this.theArray[index];
            for (let i=index; i< this.nElements; i++) {
                this.theArray[i] = this.theArray[i+1]
            }
            console.log(`Removed ${removeValue} at index ${index} from array.`);
            this.nElements--;

        }
    }

    indexOf = (element:number) => {
        for (let i:number = 0; i<this.nElements; i++) {
            if (this.theArray[i] === element) {
                return i;
            }
        }
        return -1;
    }
}

const testArr = new StaticArray(3);
testArr.insert(34);
testArr.insert(42);
testArr.insert(35);
testArr.insert(42);
testArr.insert(-20);
testArr.print();
testArr.removeAt(0);
testArr.print();
console.log(testArr.indexOf(42));

