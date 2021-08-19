module.exports ={
    devServer: {
        proxy: {
            '/api':{
                //target: 'http://165.227.206.19:8080',
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true//,
                /*onProxyReq: function(request){
                    request.setHeader("origin",'http://165.227.206.19:8080');
                }*/
            }
        }
    },
    outputDir: 'target/dist',
    assetsDir: 'static',
}