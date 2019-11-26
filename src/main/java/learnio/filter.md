<i>转自廖雪峰的Java教程IO一讲</i>

Java的IO标准库提供的<kbd>InputStream</kbd>根据来源可以包括：

- <kbd>FileInputStream</kbd>：从文件读取数据，是最终数据源；
- <kbd>-ServletInputStream</kbd>：从HTTP请求读取数据，是最终数据源；
- <kbd>Socket.getInputStream()</kbd>：从TCP连接读取数据，是最终数据源；
- ...

如果我们要给<kbd>FileInputStream</kbd>添加缓冲功能，则可以从<kbd>FileInputStream</kbd>派生一个类：

```BufferedFileInputStream extends FileInputStream```

如果要给<kbd>FileInputStream</kbd>添加计算签名的功能，类似的，也可以从<kbd>FileInputStream</kbd>派生一个类：

```DigestFileInputStream extends FileInputStream```

如果要给<kbd>FileInputStream</kbd>添加加密/解密功能，还是可以从<kbd>FileInputStream</kbd>派生一个类：

```CipherFileInputStream extends FileInputStream```

如果要给<kbd>FileInputStream</kbd>添加缓冲和签名的功能，那么我们还需要派生<kbd>BufferedDigestFileInputStream</kbd>。如果要给<kbd>FileInputStream</kbd>添加缓冲和加解密的功能，则需要派生<kbd>BufferedCipherFileInputStream</kbd>。

我们发现，给<kbd>FileInputStream</kbd>添加3种功能，至少需要3个子类。这3种功能的组合，又需要更多的子类：

```
                          ┌─────────────────┐
                          │ FileInputStream │
                          └─────────────────┘
                                   ▲
             ┌───────────┬─────────┼─────────┬───────────┐
             │           │         │         │           │
┌───────────────────────┐│┌─────────────────┐│┌─────────────────────┐
│BufferedFileInputStream│││DigestInputStream│││CipherFileInputStream│
└───────────────────────┘│└─────────────────┘│└─────────────────────┘
                         │                   │
    ┌─────────────────────────────┐ ┌─────────────────────────────┐
    │BufferedDigestFileInputStream│ │BufferedCipherFileInputStream│
    └─────────────────────────────┘ └─────────────────────────────┘

```



因此，直接使用继承，为各种<kbd>InputStream</kbd>附加更多的功能，根本无法控制代码的复杂度，很快就会失控。

为了解决依赖继承会导致子类数量失控的问题，JDK首先将<kbd>InputStream</kbd>分为两大类：

一类是直接提供数据的基础<kbd>InputStream</kbd>，例如：

- FileInputStream
- ByteArrayInputStream
- ServletInputStream
- ...
  一类是提供额外附加功能的<kbd>InputStream</kbd>，例如：

- BufferedInputStream
- DigestInputStream
- CipherInputStream
- ...
  当我们需要给一个“基础”<kbd>InputStream</kbd>附加各种功能时，我们先确定这个能提供数据源的<kbd>InputStream</kbd>，因为我们需要的数据总得来自某个地方，例如，<kbd>FileInputStream</kbd>，数据来源自文件：

```InputStream file = new FileInputStream("test.gz");```
紧接着，我们希望<kbd>FileInputStream</kbd>能提供缓冲的功能来提高读取的效率，因此我们用<kbd>BufferedInputStream</kbd>包装这个<kbd>InputStream</kbd>，得到的包装类型是<kbd>BufferedInputStream</kbd>，但它仍然被视为一个<kbd>InputStream</kbd>：

```InputStream buffered = new BufferedInputStream(file);```
最后，假设该文件已经用gzip压缩了，我们希望直接读取解压缩的内容，就可以再包装一个<kbd>GZIPInputStream</kbd>：

```InputStream gzip = new GZIPInputStream(buffered);```
无论我们包装多少次，得到的对象始终是<kbd>InputStream</kbd>，我们直接用<kbd>InputStream</kbd>来引用它，就可以正常读取：

```
┌─────────────────────────┐
│GZIPInputStream          │
│┌───────────────────────┐│
││BufferedFileInputStream││
││┌─────────────────────┐││
│││   FileInputStream   │││
││└─────────────────────┘││
│└───────────────────────┘│
└─────────────────────────┘

```

上述这种通过一个“基础”组件再叠加各种“附加”功能组件的模式，称之为Filter模式（或者装饰器模式：Decorator）。它可以让我们通过少量的类来实现各种功能的组合：

```                       
                 ┌─────────────┐
                 │ InputStream │
                 └─────────────┘
                       ▲ ▲
┌────────────────────┐ │ │ ┌─────────────────┐
│  FileInputStream   │─┤ └─│FilterInputStream│
└────────────────────┘ │   └─────────────────┘
┌────────────────────┐ │     ▲ ┌───────────────────┐
│ByteArrayInputStream│─┤     ├─│BufferedInputStream│
└────────────────────┘ │     │ └───────────────────┘
┌────────────────────┐ │     │ ┌───────────────────┐
│ ServletInputStream │─┘     ├─│  DataInputStream  │
└────────────────────┘       │ └───────────────────┘
                             │ ┌───────────────────┐
                             └─│CheckedInputStream │
                               └───────────────────┘     
```


类似的，<kbd>OutputStream</kbd>也是以这种模式来提供各种功能：

```
                  ┌─────────────┐
                  │OutputStream │
                  └─────────────┘
                        ▲ ▲
┌─────────────────────┐ │ │ ┌──────────────────┐
│  FileOutputStream   │─┤ └─│FilterOutputStream│
└─────────────────────┘ │   └──────────────────┘
┌─────────────────────┐ │     ▲ ┌────────────────────┐
│ByteArrayOutputStream│─┤     ├─│BufferedOutputStream│
└─────────────────────┘ │     │ └────────────────────┘
┌─────────────────────┐ │     │ ┌────────────────────┐
│ ServletOutputStream │─┘     ├─│  DataOutputStream  │
└─────────────────────┘       │ └────────────────────┘
                              │ ┌────────────────────┐
                              └─│CheckedOutputStream │
                                └────────────────────┘

```



