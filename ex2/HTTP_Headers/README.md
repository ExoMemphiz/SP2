#### 1

GET /HTTP_Headers/ HTTP/1.1		- Which request type is used
Host: localhost:8084		- Which address connection is established to
Cache-Control: max-age=0		- How long cache may stay
User-Agent: 		- Which browser is being used
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8		- What file types it can accept
Accept-Encoding: gzip, deflate, sdch, br		- Which encoding type it can accept
Accept-Language: da-DK,da;q=0.8,en-US;q=0.6,en;q=0.4		- Which language it can accept


#### 2
Connection header is there to tell the server if it should keep the TCP connection open, or if it should be closed (Defined by "Connection: close", intead of keep-alive.

#### 3

First connection is to the server, which tells what other resources the page needs to be displayed correctly.
The next is the css style sheet so the rendering of elements on the page is presented as planned.
3rd is the bundled javascript needed to make the page function - button clicks etc.

#### Get HTTP Request Headers on the Server (Servlet)

[Servlet Table Image](https://puu.sh/w7CmC/db55e8bd13.png)