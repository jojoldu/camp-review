/**
 * Created by jojoldu@gmail.com on 2017. 7. 9.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

import Woowahan from 'woowahan';
import Template from './main.hbs';

export default Woowahan.View.create('MainView', {
    template: Template,

    initialize() {
        this.super();
    }
});