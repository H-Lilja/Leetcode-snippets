function strStr(haystack: string, needle: string): number {
    //If regex of searchable sentence is found, it returns it, otherwise it returns -1
    return haystack.search(needle);
};
// print out the result
console.log(strStr("sadbutsad","sad"));
