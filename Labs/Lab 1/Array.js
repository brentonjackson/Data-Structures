var StaticArray = /** @class */ (function () {
    function StaticArray(size) {
        var _this = this;
        this.print = function () {
            console.log("[");
            for (var i = 0; i < _this.theArray.length; i++) {
                if (i < _this.nElements - 1) {
                    console.log(_this.theArray[i] + ", ");
                }
                else {
                    console.log(_this.theArray[i] + "]");
                }
            }
        };
        this.insert = function (e) {
            if (_this.theArray.length == _this.nElements) {
                var doubledArray_1 = new Array(_this.nElements * 2);
                _this.theArray.forEach(function (el, i) {
                    doubledArray_1[i] = el;
                });
                _this.theArray = doubledArray_1;
            }
            _this.theArray[_this.nElements] = e;
            _this.nElements++;
            console.log("Added ".concat(e, " to array."));
        };
        this.removeAt = function (index) {
            if ((index < 0) || (index >= _this.nElements)) {
                throw new RangeError("Index out of range");
            }
            else {
                var removeValue = _this.theArray[index];
                for (var i = index; i < _this.nElements; i++) {
                    _this.theArray[i] = _this.theArray[i + 1];
                }
                console.log("Removed ".concat(removeValue, " at index ").concat(index, " from array."));
                _this.nElements--;
            }
        };
        this.indexOf = function (element) {
            for (var i = 0; i < _this.nElements; i++) {
                if (_this.theArray[i] === element) {
                    return i;
                }
            }
            return -1;
        };
        this.theArray = new Array(size);
        this.nElements = 0;
        console.log(this.theArray);
    }
    return StaticArray;
}());
var testArr = new StaticArray(3);
testArr.insert(34);
testArr.insert(42);
testArr.insert(35);
testArr.insert(42);
testArr.insert(-20);
testArr.print();
testArr.removeAt(0);
testArr.print();
console.log(testArr.indexOf(42));
