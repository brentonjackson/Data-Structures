// You are given an array that consists of n ≥ 0 pairs of integers, and one unique number.

let findUnique = (arr:Array<number>) => {
    let numCounts:{[k: string]: any} = {};
    for (let i:number=0; i< arr.length; i++) {
        numCounts[arr[i]] = 0;
    }
    for (let i:number=0; i< arr.length; i++) {
        numCounts[arr[i]]++;
    }
    console.log(numCounts)
    for (let i:number=0; i< arr.length; i++) {
        if (numCounts[arr[i]] == 1) {
            return arr[i]
        }
    }
   
}

console.log(findUnique([0,2,-4,5,2,0,-4]))
console.log(findUnique([3,3,3,3,6,6,7]))