function setInitialCSS() {
    var textareaObject = document.getElementById('cssBox');
    
    var string = 'h2 { \n' + '   color: #FF6F61;\n' + '   text-align: center;\n' + '}\n\n'
                    + 'p {\n' + '   font-family: helvetica;\n' + '   font-size: 20px;\n'
                    + '   border: 2px solid red;\n' + '   border-radius: 12px;\n' + '}\n\n';
    
    textareaObject.value = string;
}

function setInitialHTML() {
    var textareaObject = document.getElementById('htmlBox');
    
    var string = '<h2>Welcome to my text editor!</h2>\n\n' +
                 '<p>You can test and create your own HTML and CSS in this text editor</p>\n\n';
    
    textareaObject.value = string;
}

function clearTextarea() {
    var textareaObject = document.getElementById('eraseButton');
    var htmlIframe = document.getElementById('code');
    var htmlButton = document.getElementById('htmlButton');

    htmlButton.style.backgroundColor = "black";
                
    textareaObject.value = null;  // don't set to empty string, empty string has a value still
    htmlIframe.style.display = 'none';
} 


function setHTMLButton(){
    var htmlText = document.getElementById('htmlBox').innerHTML;
    
    while(htmlText == null)
    {
        var buttonObject = document.getElementById('htmlButton').style.backgroundColor = "black";
    }
    
    var buttonObject = document.getElementById('htmlButton').style.backgroundColor = "lightgreen";
}

function setCSSButton(){
    
   var cssText = document.getElementById('cssBox').value;
    
    while(cssText == null)
    {
        var buttonObject = document.getElementById('cssButton').style.backgroundColor = "black";
    }
    
    var buttonObject = document.getElementById('cssButton').style.backgroundColor = "gold";
}

// Help with getting HTML to show up in the right area from:
// https://www.youtube.com/watch?v=H2NbneSEEV4  name: Alkylbenzenesulfonate
function writeToDiv(){
    
    var htmlTextarea = document.getElementById('htmlBox').value;
    var iframe = document.getElementById('code');
    
    iframe.style.display = 'block';
    
    iframe.setAttribute("frameborder", "0");
    
    iframe = (iframe.contentWindow) ? iframe.contentWindow: (iframe.contentDocument) ? iframe.contentDocument.document: iframe.contentDocument;
    
    iframe.document.open();
    iframe.document.write(htmlTextarea);
    iframe.document.close();
    return false;
}
// end of Alkylbenzenesulfonate

function allHTML(){
    setHTMLButton();
    writeToDiv();
}

function allCSS() {
    setCSSButton();
    useCSS();
}

// I couldn't figure out how to inject the CSS into my div b/c I created an iframe to house the html code
// I looked everywhere and really couldn't understand how to get anything to work. I'll be coming to 
// some office hours to get a better understanding of the intended implementation
function useCSS() {
//    var style = document.createElement('style');
//    style.type = 'text/css';
//    style.innerHTML = 'content';
//    document.getElementsByTagName('head')[0].appendChild(style);    
}

/* Prompt box help from w3schools Prompt Box information page */
function titleChange() {
    var newTitle = prompt("What do you want to change the title of the webpage to?", "New Title");
    
    if(newTitle != null){
        document.getElementById('pageTitle').innerHTML = newTitle;
    }
}
/* end of prompt box */

function changeShadow() {
    document.getElementsByClassName('textArea').style.boxShadow = "10px 10px 10px yellow";
}