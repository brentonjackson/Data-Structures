class LinkedList {
    private head:Node;
    private tail:Node;
    
}

class Node {
    private _value:number;
    private _next:any;

    constructor(value:number) {
        this._value = value;
    }

    set next (theNode:Node){
        this._next = theNode;
    }

}