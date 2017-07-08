
import Woowahan from 'woowahan';
import Style from './app.scss';


const Main = Woowahan.View.create('Main', {
    template: '<h1>Hello, WoowahanJs</h1>'
});

const app = Woowahan();

app.start({
    url: '/', container: 'body', view: Main
});