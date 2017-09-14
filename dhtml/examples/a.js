var someText= "web2.0 .net2.0" ;
var pattern=/(\w+)(\d)\.(\d)/g;
var outCome_exec=pattern.exec(someText);
var outCome_matc=someText.match(pattern);
console.log(outCome_exec);
console.log(outCome_matc);
const ncname = '[a-zA-Z_][\\w\\-\\.]*';
const qnameCapture = `((?:${ncname}\\:)?${ncname})`;
const startTagOpen = new RegExp(`^<${qnameCapture}`);
const startTagClose = /^\s*(\/?)>/;
const endTag = new RegExp(`^<\\/${qnameCapture}[^>]*>`);

var html = `</a>`;
var m1 = html.match(endTag);
console.log(m1);