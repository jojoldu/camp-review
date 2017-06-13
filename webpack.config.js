/**
 * Created by jojoldu@gmail.com on 2017. 6. 13.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

const webpack = require('webpack');
const entry = './index.js';
const output = {
    path: __dirname,
    filename: 'woowahan.js'
};

const uglifyJsPlugin = new webpack.optimize.UglifyJsPlugin({
    compressor: {
        screw_ie8: true,
        warnings: false
    },
    output: {
        comments: false
    }
});

module.exports = {
    debug: false,
    devtool: 'cheap-module-eval-source-map',
    entry: entry,
    output: output,
    module : {
        loaders : [
            { test: /\.js?$/, exclude: /node_modules/, loader: 'babel-loader' },
            { test: /\.css$/, exclude: /node_modules/, loader: 'css-loader' },
            { test: /\.hbs$/, loader: 'handlebars-loader', query: { helperDirs: [__dirname+'/template-helper'] }}
        ]
    },
    plugins: [ uglifyJsPlugin ]
};